package P04_DetailPrinter;

public abstract class BaseEmployee implements Person {
    private String name;

    protected BaseEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }


}
