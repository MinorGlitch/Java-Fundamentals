package p03_employee_info;

public class Main {

    public static void main(String[] args) {
        ConsoleClient consoleClient = new ConsoleClient(new ConsoleFormatter(),
                new EmployeeInfoProvider(new EmployeeDatabase()));

        System.out.println(consoleClient.format());
    }
}
