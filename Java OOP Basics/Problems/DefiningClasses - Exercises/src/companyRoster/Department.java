package companyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Department {
    private List<Employee> employees;
    private String name;

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(String name) {
        this.employees = new ArrayList<>();
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getDepartmentSum() {
        double average = employees.stream().mapToDouble(s -> s.getSalary()).sum();

        return average;
    }
}
