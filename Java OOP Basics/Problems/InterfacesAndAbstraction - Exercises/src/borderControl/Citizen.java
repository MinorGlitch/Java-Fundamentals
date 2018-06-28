package borderControl;

public class Citizen implements Individual {
    private String id;
    private String name;
    private int age;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
