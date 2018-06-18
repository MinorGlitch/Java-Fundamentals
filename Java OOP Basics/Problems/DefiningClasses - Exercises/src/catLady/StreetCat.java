package catLady;

public class StreetCat extends Cat {
    private double decibelsOfMeows;
    private static final String TYPE = "StreetExtraordinaire";


    public StreetCat(double decibelsOfMeows, String name) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public double getDecibelsOfMeows() {
        return this.decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", TYPE, super.toString(), this.getDecibelsOfMeows());
    }
}
