package foodShortage;

public class Rebel extends BaseIndividual {


    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public int getFood() {
        return super.food;
    }

    @Override
    public void buyFood() {
        super.food += 5;
    }

    @Override
    public String getGroup() {
        return super.group;
    }
}
