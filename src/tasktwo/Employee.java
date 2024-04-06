package tasktwo;

/**
 * @author SDudin
 */

public class Employee {
    private String name;
    private Integer age;
    private String position;

    public Employee(String name, Integer age, String position){
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
