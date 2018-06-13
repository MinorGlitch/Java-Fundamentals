package carSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    private static final int DISPLACEMENT_DEFAULT = -1;
    private static final String EFFICIENCY_DEFAULT = "n/a";

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DISPLACEMENT_DEFAULT;
        this.efficiency = EFFICIENCY_DEFAULT;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = EFFICIENCY_DEFAULT;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
        this.displacement = DISPLACEMENT_DEFAULT;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
