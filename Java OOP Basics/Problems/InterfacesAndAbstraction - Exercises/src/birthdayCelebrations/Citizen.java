package birthdayCelebrations;

public class Citizen extends BaseIndividual {
    private int age;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, id, birthDate);
        this.age = age;
    }

}
