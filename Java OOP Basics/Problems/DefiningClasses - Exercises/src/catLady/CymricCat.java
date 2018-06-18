package catLady;

public class CymricCat extends Cat {
    private double furLength;
    private static final String TYPE = "Cymric";

    public CymricCat(double furLength, String name) {
        super(name);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", TYPE, super.toString(), this.getFurLength());
    }
}
