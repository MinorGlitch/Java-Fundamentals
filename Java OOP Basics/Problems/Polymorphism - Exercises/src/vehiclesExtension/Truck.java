package vehiclesExtension;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, 1.6);
    }

    @Override
    public boolean refillVehicle(double litres) {
        return super.refillVehicle(litres * 0.95);
    }
}
