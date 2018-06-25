package vehiclesExtension;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity, double increaseRate) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption + increaseRate;
        this.tankCapacity = tankCapacity;
    }

    protected boolean drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;

        if (fuelQuantity < fuelNeeded) {
            return false;
        }

        fuelQuantity -= fuelNeeded;

        return true;
    }

    protected boolean refillVehicle(double litres) {
        if (litres > this.tankCapacity) {
            return false;
        }

        this.fuelQuantity += litres;

        return true;
    }
}
