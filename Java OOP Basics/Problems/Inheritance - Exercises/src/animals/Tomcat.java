package animals;

public class Tomcat extends Cat {
    private static final String SOUND = "Give me one million b***h";

    public Tomcat(String name, int age) {
        super(name, age, "Male");
        super.type = "Tomcat";
    }

    public void produceSound() {
        System.out.println(SOUND);
    }
}
