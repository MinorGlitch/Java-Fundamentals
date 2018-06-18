package shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name.trim());
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    private void setName(String name) {
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }
}
