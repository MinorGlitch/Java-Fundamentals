package cars;

public final class CarFactory {
    public static Car createCar(String type, String brand, String model,
                                int yearOfProduction, int horsepower,
                                int acceleration, int suspension, int durability) {
        CarType types = CarType.valueOf(type.toUpperCase());

        switch (types) {
            case SHOW:
                return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration,
                        suspension, durability);
            case PERFORMANCE:
                return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration,
                        suspension, durability);
            default:
                return null;
        }
    }
}
