package vehicles;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double increaseRate) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption + increaseRate;
    }

    protected boolean drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;

        if (fuelQuantity < fuelNeeded) {
            return false;
        }

        fuelQuantity -= fuelNeeded;

        return true;
    }

    protected void refillVehicle(double litres) {
        this.fuelQuantity += litres;
    }
}
