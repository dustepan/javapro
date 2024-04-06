package tasktwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author SDudin
 */
public class TaskTwoMain {
    public static void main(String[] args) {
        //Первое задание(удаление дубликатов)
        List<String> listWithDublicate = List.of("Java", "Pro", "Modul", "Java");
        List<String> listWithOutDublicate = listWithDublicate.stream()
                .distinct()
                .toList();
        System.out.println(listWithOutDublicate);

        //Второе задание(3 наибольшее число)
        List<Integer> listWithMax = List.of(5, 2, 10, 9, 4, 3, 10, 1, 13);
        Integer maxValueThirdPlace = listWithMax.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .toList()
                .get(0);
        System.out.println(maxValueThirdPlace);

        //Третье задание(3 наибольшее число без дубликата)
        Integer maxValueThirdPlaceDublicate = listWithMax.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .toList()
                .get(0);
        System.out.println(maxValueThirdPlaceDublicate);

        //Четвертое задание(3 старших сотрудника инженера)
        Employee employee1 = new Employee("Stiv", 20, "Секретарь");
        Employee employee2 = new Employee("Petr", 40, "Инженер");
        Employee employee3 = new Employee("Ivan", 25, "Директор");
        Employee employee4 = new Employee("Evgen", 60, "Инженер");
        Employee employee5 = new Employee("Denis", 10, "Инженер");
        Employee employee6 = new Employee("Lil", 12, "Инженер");
        List<Employee> employeeLists = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
        List<String> nameList = employeeLists.stream()
                .filter(employee -> "Инженер".equals(employee.getPosition()))
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(3)
                .map(Employee::getName)
                .toList();
        System.out.println(nameList);

        //Пятое задание(средний возраст инженера)
        Double averageAge = employeeLists.stream()
                .filter(employee -> "Инженер".equals(employee.getPosition()))
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(averageAge);

        //Шестое задание(самое длинное слово в списке)
        List<String> wordList = List.of("Привет", "АлексндрМеняЗовут", "Степан");
        String maxWordLength = wordList.stream()
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println(maxWordLength);

        //Седьмое задание(слово и его количество повторений)
        String string = "привет это курс java pro привет pro";
        System.out.println(Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting())));

        //Восьмое задание
        List<String> listWords = List.of("вагага", "бугаг", "рататата", "агагг", "ваг", "рататт", "авг");
        List<String> list = listWords.stream()
                .sorted()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(list);

        //Девятое задание
        String[] arr = {"а аб абв абвг абвг", "курс по java супер класс", "я работаю в компании иннотех"};
        String maxString = Arrays.stream(arr)
                .flatMap(word -> Stream.of(word.split(" ")))
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println(maxString);
    }
}
