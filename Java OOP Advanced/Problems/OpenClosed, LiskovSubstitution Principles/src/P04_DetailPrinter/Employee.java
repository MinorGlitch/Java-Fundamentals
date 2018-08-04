package P04_DetailPrinter;

public class Employee extends BaseEmployee {
    public Employee(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(super.getName());
    }
}
