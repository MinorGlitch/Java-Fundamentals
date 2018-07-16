package comparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setTown(town);
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

    public String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        int comparedByName = this.getName().compareTo(o.getName());

        if (comparedByName != 0) {
            return comparedByName;
        }

        int comparedByAge = this.getAge() - o.getAge();

        if (comparedByAge != 0) {
            return comparedByAge;
        }

        return this.getTown().compareTo(o.getTown());
    }
}
