package vehicles;

public class Truck extends Vehicle {
    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, 1.6);
    }

    @Override
    public void refillVehicle(double litres) {
        super.fuelQuantity += litres * 0.95;
    }
}
