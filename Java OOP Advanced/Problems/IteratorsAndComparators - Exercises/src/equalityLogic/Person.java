package equalityLogic;

public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person o) {
        int comparedByName = this.getName().compareTo(o.getName());

        if (comparedByName != 0) {
            return comparedByName;
        }

        return this.getAge() - o.getAge();
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;

        return this.compareTo(person) == 0;
    }
}
