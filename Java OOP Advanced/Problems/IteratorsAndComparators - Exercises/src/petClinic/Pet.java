package petClinic;

public class Pet {
    private int age;
    private String kind;
    private String name;

    public Pet() {}

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.kind;
    }
}
