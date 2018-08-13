package p03_employee_info;

import java.util.List;

public interface InfoProvider {
    List<Employee> getEmployeesByName();
    List<Employee> getEmployeesBySalary();
}
