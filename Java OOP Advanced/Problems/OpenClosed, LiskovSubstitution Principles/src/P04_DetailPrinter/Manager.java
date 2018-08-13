package P04_DetailPrinter;

public class Manager extends BaseEmployee {

    private Iterable<String> documents;

    public Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }

    @Override
    public void print() {
        System.out.println(super.getName() + String.join(", ", this.documents));
    }
}
