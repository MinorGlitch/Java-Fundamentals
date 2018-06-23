package animals;

public class Animal {
    private String name;
    private int age;
    private Gender gender;
    protected String type;

    protected static final String INVALID_INPUT_MESSAGE = "Invalid input!";

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public Animal(String name, int age, String gender, String type) {
        this(name, age, gender);
        this.type = type;
    }

    private void setGender(String gender) {
        this.gender = new Gender(gender);
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.age = age;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.name = name;
    }

    protected void produceSound() {
        System.out.println("Not implemented!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.type).append("\n");
        sb.append(this.name).append(" ").append(this.age).append(" ").append(this.gender.getGender());

        return sb.toString();
    }
}
