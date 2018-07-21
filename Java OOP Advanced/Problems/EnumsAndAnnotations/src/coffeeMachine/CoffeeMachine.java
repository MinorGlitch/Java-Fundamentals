package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffees;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        int balance = this.coins.stream().mapToInt(Coin::getValue).sum();

        Coffee coffee = new Coffee(size, type);

        if (coffee.getCoffeeSize().getPrice() > balance) {
            this.coffees.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin) {
        this.coins.add(Enum.valueOf(Coin.class, coin.toUpperCase()));
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }
}
