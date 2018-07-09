package cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;
    private int performancePoints;
    private int reward;

    protected Car(String brand, String model,
               int yearOfProduction, int horsepower,
               int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    public int getPerformancePoints() {
        return performancePoints;
    }

    public void setPerformancePoints(int performancePoints) {
        this.performancePoints = performancePoints;
    }

    public int getReward() {
        return reward;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d%n", this.getBrand(), this.getModel(), this.getYearOfProduction()));
        sb.append(String.format("%s HP, 100 m/h in %d s%n", this.getHorsepower(), this.getAcceleration()));
        sb.append(String.format("%s Suspension force, %d Durability%n", this.getSuspension(), this.getDurability()));

        return sb.toString();
    }

    public void tuneHorsepower(int tuneIndex) {
        this.horsepower += tuneIndex;
    }

    public void tuneSuspension(int tuneIndex) {
        this.suspension += tuneIndex / 2;
    }

    public abstract void tune(String... args);
}
