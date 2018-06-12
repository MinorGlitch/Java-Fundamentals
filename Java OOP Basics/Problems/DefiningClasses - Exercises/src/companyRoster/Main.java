package companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        Map<String, Department> departments = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] employeeData = reader.readLine().split(" ");

            String name = employeeData[0];
            double salary = Double.valueOf(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];

            int age;

            Employee employee;

            if (employeeData.length == 5){
                String val = employeeData[4];
                try {
                    age = Integer.valueOf(val);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException ex) {
                    employee = new Employee(name, salary, position, department, val);
                }

            } else if (employeeData.length == 6) {
                String email = employeeData[4];
                age = Integer.valueOf(employeeData[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                employee = new Employee(name, salary, position, department);
            }

            departments.putIfAbsent(department, new Department(department));

            departments.get(department).addEmployee(employee);
        }

        departments.values()
                .stream()
                .sorted((a, b) -> Double.compare(b.getDepartmentSum(), a.getDepartmentSum()))
                .limit(1)
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getName());
                    d.getEmployees()
                            .stream()
                            .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                            .forEach(e -> {
                                System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary()
                                , e.getEmail(), e.getAge());
                            });
                });
    }
}
