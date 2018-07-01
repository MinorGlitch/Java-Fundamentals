package foodShortage;

public class Citizen extends BaseIndividual {
    private int age;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, id, birthDate);
        this.age = age;
    }

    @Override
    public int getFood() {
        return super.food;
    }

    @Override
    public void buyFood() {
        super.food += 10;
    }

    @Override
    public String getGroup() {
        return super.group;
    }
}
