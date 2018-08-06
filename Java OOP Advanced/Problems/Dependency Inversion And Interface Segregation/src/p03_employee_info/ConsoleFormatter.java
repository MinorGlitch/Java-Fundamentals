package p03_employee_info;

import java.util.List;

public class ConsoleFormatter implements Formatter {

    public String format(List<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
