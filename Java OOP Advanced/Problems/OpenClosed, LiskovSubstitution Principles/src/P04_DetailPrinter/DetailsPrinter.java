package P04_DetailPrinter;

public class DetailsPrinter {

    private Iterable<Person> employees;

    public DetailsPrinter(Iterable<Person> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Person employee : employees) {
            employee.print();
        }
    }
}
