package p03_employee_info;

import java.util.List;

public class ConsoleClient {
    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    public String format() {
        List<Employee> employees = this.infoProvider.getEmployeesByName();

        return this.formatter.format(employees);
    }
}
