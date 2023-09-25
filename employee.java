
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private String name;
    private double salary;
    private String gender;
    
    public Employee(String name, double salary, String gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }
}

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, double salary, String gender) {
        Employee employee = new Employee(name, salary, gender);
        employees.add(employee);
    }

    public double calculateAverageSalaryByGender(String gender) {
        double totalSalary = 0.0;
        int employeeCount = 0;

        for (Employee employee : employees) {
            if (employee.getGender().equalsIgnoreCase(gender)) {
                totalSalary += employee.getSalary();
                employeeCount++;
            }
        }

        if (employeeCount == 0) {
            return 0.0; // Avoid division by zero
        } else {
            return totalSalary / employeeCount;
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Add employees
        manager.addEmployee("pranjal", 50000.0, "female");
        manager.addEmployee("Aman", 60000.0, "male");
        manager.addEmployee("priya", 75000.0, "Female");
        manager.addEmployee("aarav", 55000.0, "Male");

        // Calculate the average salary for males and females
        double averageMaleSalary = manager.calculateAverageSalaryByGender("Male");
        double averageFemaleSalary = manager.calculateAverageSalaryByGender("Female");

        // Print the results
        System.out.println("Average Male Salary: " + averageMaleSalary);
        System.out.println("Average Female Salary: " + averageFemaleSalary);
    }
}

