package catLady;

public class SiameseCat extends Cat {
    private double earLength;
    private static final String TYPE = "Siamese";

    public SiameseCat(double earLength, String name) {
        super(name);
        this.earLength = earLength;
    }

    public double getEarLength() {
        return earLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", TYPE, super.toString(), this.getEarLength());
    }
}
