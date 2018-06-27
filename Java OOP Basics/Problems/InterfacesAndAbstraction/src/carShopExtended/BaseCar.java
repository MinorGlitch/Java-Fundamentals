package carShopExtended;

public abstract class BaseCar implements Car {
    protected String countryProduced;
    protected String model;
    protected String color;
    protected Integer horsePower;

    protected BaseCar(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This %s is produced in %s and has %d tires", this.getModel(), this.getCountryProduced()
                , TIRES);
    }
}
