package rpg_lab;

import rpg_lab.interfaces.Inventory;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class Dummy implements Target {

    private int health;
    private int experience;
    private Inventory inventory;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.inventory = new InventoryImpl();
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public Weapon giveWeapon() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.inventory.getWeapon();
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
