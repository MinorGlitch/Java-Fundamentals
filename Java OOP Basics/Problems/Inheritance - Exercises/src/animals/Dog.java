package animals;

public class Dog extends Animal {
    private static final String SOUND = "BauBau";


    public Dog(String name, int age, String gender) {
        super(name, age, gender);
        super.type = "Dog";
    }

    public void produceSound() {
        System.out.println(SOUND);
    }
}
