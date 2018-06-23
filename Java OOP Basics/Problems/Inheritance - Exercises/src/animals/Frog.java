package animals;

public class Frog extends Animal {
    private static final String SOUND = "Frogggg";

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
        super.type = "Frog";
    }

    public void produceSound() {
        System.out.println(SOUND);
    }
}
