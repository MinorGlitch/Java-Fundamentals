package models.engines;

public class SterndriveEngine extends BaseEngine {
    private static final int Multiplier = 7;

    private int cachedOutput;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    public int getOutput() {
        if (this.cachedOutput != 0) {
            return this.cachedOutput;
        }

        this.cachedOutput = (super.getHorsepower() * Multiplier) + super.getDisplacement();
        return this.cachedOutput;
    }

}
