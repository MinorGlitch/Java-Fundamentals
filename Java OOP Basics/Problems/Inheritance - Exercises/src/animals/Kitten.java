package animals;

public class Kitten extends Cat {
    private static final String SOUND = "Miau";

    public Kitten(String name, int age) {
        super(name, age, "Female");
        super.type = "Kitten";
    }

    public void produceSound() {
        System.out.println(SOUND);
    }
}
