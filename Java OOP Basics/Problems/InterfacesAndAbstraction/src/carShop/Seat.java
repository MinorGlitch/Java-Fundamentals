package carShop;

import java.io.Serializable;

public class Seat implements Car, Serializable {
    private String countryProduced;
    private String model;
    private String color;
    private Integer horsePower;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    private String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This %s is produced in %s and has %d tires", this.getModel(), this.getCountryProduced()
                , TIRES);
    }
}
