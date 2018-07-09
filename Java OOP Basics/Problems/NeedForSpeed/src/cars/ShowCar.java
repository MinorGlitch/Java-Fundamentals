package cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction,
                   int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(String.format("%d *%n", this.stars));

        return sb.toString().trim();
    }

    @Override
    public void tune(String... args) {
        this.stars += Integer.valueOf(args[0]);
    }
}
