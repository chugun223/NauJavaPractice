import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иванов Иван Иванович",23, "аналитика",120000.7));
        employees.add(new Employee("Петров Пётр петрович",35,"бэкенд",85000.7));
        employees.add(new Employee("Волков Волк Волкоич",19,"фронтенд",150000.4));
        employees.add(new Employee("Князев Князь князевич",22,"девопс",135000.4));
        employees.add(new Employee("Смирнов Смирн Смирнович",22,"маркетинг",98000.1));
        employees.add(new Employee("Сидоров Сидор Сидорович",28,"аналитика",105000.1));

        System.out.println("Задание №3. Stream API.");
        System.out.println("исходный список сотрудников:");
        employees.forEach(System.out::println);
        List<String> result = employees.stream().map(e -> e.getFullName() + " - " + e.getDepartment()).collect(Collectors.toList());
        System.out.println();
        System.out.println("список сотрудников вида: Имя - Отдел");
        result.forEach(System.out::println);
        System.out.println("Задание №3 завершено.");
    }
}
class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName(){
        return fullName;
    }
    public Integer getAge(){
        return age;
    }
    public String getDepartment(){
        return department;
    }
    public Double getSalary(){
        return salary;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSalary(Double salary){
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("сотрудник(полное имя: %s, возраст: %d лет, отдел: %s, зарплата = %.2f)", fullName, age, department, salary);
    }
}
