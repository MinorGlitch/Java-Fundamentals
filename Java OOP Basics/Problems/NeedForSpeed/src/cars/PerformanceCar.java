package cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + (horsepower * 50 / 100));
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension - (suspension * 25 / 100));
    }

    public List<String> getAddOns() {
        return addOns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        String addOns = this.addOns.size() != 0 ? String.join(", ", this.addOns) : "None";

        sb.append(String.format("Add-ons: %s%n", addOns));

        return sb.toString().trim();
    }

    @Override
    public void tune(String... args) {
        this.addOns.add(args[0]);
    }
}
