package speedRacing;

public class Car {
    private String model;
    private int fuelAmount;
    private double fuelCostPerKilometer;
    private int distanceTravelled;

    public Car(String model, int fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
    }

    public boolean canDrive(int kilometers) {
        return kilometers < fuelAmount
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public void setFuelCostPerKilometer(double fuelCostPerKilometer) {
        this.fuelCostPerKilometer = fuelCostPerKilometer;
    }

}
