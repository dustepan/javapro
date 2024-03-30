package taskone.methods;

import taskone.annotation.AfterSuite;
import taskone.annotation.BeforeSuite;
import taskone.annotation.Test;

/**
 * @author SDudin
 */
public class TestClassForAnnotation {

    @BeforeSuite
    public static void methodForGreetings() {
        System.out.println("Добро пожаловать на курс");
    }

    @Test(priority = 2)
    public void methodForStatus() {
        System.out.println("Ты проходишь курс JavaPRO 2");
    }

    @Test(priority = 3)
    public static void methodForSuccessEnding() {
        System.out.println("Ты успешно прошел курс JavaPRO 3");
    }

    @Test(priority = 4)
    public static void methodTwoForSuccessEnding() {
        System.out.println("Ты успешно прошел курс JavaPRO 4");
    }


    @Test
    public void methodForFailureEnding() {
        System.out.println("Ты провалил прохождение курса JavaPRO 5");
    }

    @AfterSuite
    public static void methodStaticForFailureEnding() {
        System.out.println("Ты успешно прошел курс JavaPRO");
    }


    public static void methodStaticTwoForFailureEnding() {
        System.out.println("Ты провалил прохождение курса JavaPRO");
    }
}
