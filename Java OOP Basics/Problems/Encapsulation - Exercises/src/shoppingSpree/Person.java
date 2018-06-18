package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> cart;

    public Person(String name, double money) {
        this.setName(name.trim());
        this.setMoney(money);
        this.cart = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private double getMoney() {
        return money;
    }

    private List<Product> getCart() {
        return cart;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void addProduct(Product product) {
        this.getCart().add(product);
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            throw new IllegalArgumentException(
                    String.format("%s can't afford %s", this.getName(), product.getName()));
        }

        this.setMoney(this.getMoney() - product.getCost());
        this.addProduct(product);
    }

    @Override
    public String toString() {
        return this.getName() + " - " + (this.getCart().isEmpty() ? "Nothing bought" :
                this.getCart().stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));
    }
}
