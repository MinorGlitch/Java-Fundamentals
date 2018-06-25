package vehiclesExtension;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, 0);
    }

    public boolean driveWithPeople(double distance) {
        double tempFuelConsumption = super.fuelConsumption;

        this.fuelConsumption += 1.4;

        boolean driveVal = super.drive(distance);

        this.fuelConsumption = tempFuelConsumption;

        return driveVal;
    }
}
