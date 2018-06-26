package wildFarm.food;

public abstract class Food {
    private int quantity;

    protected Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFoodType() {
        return this.getClass().getSimpleName();
    }
}
