package wildFarm.animal;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String name, double weight, String livingRegion) {
        super(name, weight);
        this.setLivingRegion(livingRegion);
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return this.getAnimalType() + "[" + this.getName() + ", "
                + df.format(this.getWeight())
                + ", " + this.getLivingRegion() + ", " + this.getFoodEaten() + "]";
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }
}
