package strategyPattern;

public class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setAge(age);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }
}
