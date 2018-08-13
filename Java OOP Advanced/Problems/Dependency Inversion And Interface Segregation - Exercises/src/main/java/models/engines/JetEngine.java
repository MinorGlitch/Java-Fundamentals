package models.engines;

public class JetEngine extends BaseEngine
{
    private static final int MULTIPLIER = 5;
    private int cachedOutput;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        if (this.cachedOutput != 0)
        {
            return this.cachedOutput;
        }

        this.cachedOutput = (super.getHorsepower() * MULTIPLIER) + super.getDisplacement();
        return this.cachedOutput;
    }

}
