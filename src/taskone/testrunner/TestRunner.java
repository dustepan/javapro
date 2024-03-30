package taskone.testrunner;

import taskone.annotation.AfterSuite;
import taskone.annotation.BeforeSuite;
import taskone.annotation.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author SDudin
 */
public class TestRunner {
    public static void runTests(Class<?> c) throws Exception {
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        Method[] declaredMethods = c.getDeclaredMethods(); //получение всех методов класса

        //проверка количества аннотаций @BeforeSuite и AfterSuite + статический метод.
        try {
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    countBeforeSuite++;
                    if (!Modifier.isStatic(method.getModifiers()))
                        throw new RuntimeException("Аннотация BeforeSuite не над static методом");
                }

                if (method.isAnnotationPresent(AfterSuite.class)) {
                    countAfterSuite++;
                    if (!Modifier.isStatic(method.getModifiers()))
                        throw new RuntimeException("Аннотация AfterSuite не над static методом");
                }
            }
            if (countBeforeSuite > 1) {
                throw new RuntimeException("Method with annotation @BeforeSuite > 1");
            }
            if (countAfterSuite > 1) {
                throw new RuntimeException("Method with annotation @AfterSuite > 1");
            }

            //проверка на корректность приоритета
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(Test.class)) {
                    if (method.getAnnotation(Test.class).priority() < 1 || method.getAnnotation(Test.class).priority() > 10) {
                        throw new RuntimeException("Введен некорректный приоритет");
                    }
                }
            }
        } catch (RuntimeException ex) {
            throw ex;
        }


        //вызов метода с аннотауией @BeforeSuite.
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class))
                method.invoke(c.getConstructor().newInstance());
        }

        //вызов методов с аннотацией @Test по приоритету
        List<Method> collect = Arrays.stream(declaredMethods)
                .filter(method1 -> method1.isAnnotationPresent(Test.class))
                .sorted(Collections.reverseOrder(Comparator.comparingInt(a -> a.getAnnotation(Test.class).priority())))
                .collect(Collectors.toList());

        for (Method method : collect) {
            if (method.isAnnotationPresent(Test.class)) {
                method.invoke(c.getConstructor().newInstance());
            }
        }

        //вызов метода с аннотауией @AfterSuite.
        for (Method method : declaredMethods) {
            AfterSuite afterSuite = method.getDeclaredAnnotation(AfterSuite.class);
            if (Objects.nonNull(afterSuite)) {
                method.invoke(c.getConstructor().newInstance());
            }
        }
    }
}
