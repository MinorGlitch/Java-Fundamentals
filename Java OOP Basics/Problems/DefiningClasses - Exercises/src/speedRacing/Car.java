package speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private int distanceTravelled;

    public Car(String model, int fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTravelled = 0;
    }

    public boolean canDrive(double kilometers) {
        return this.getFuelAmount() >= kilometers * this.getFuelCostPerKilometer();
    }

    public void drive(double kilometers) {
        this.fuelAmount -= kilometers * this.getFuelCostPerKilometer();
        this.distanceTravelled += kilometers;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }


    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getModel() {
        return model;
    }
}
