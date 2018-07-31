package rpg_lab;

import rpg_lab.interfaces.Inventory;
import rpg_lab.interfaces.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InventoryImpl implements Inventory {
    private List<Weapon> weapons;

    public InventoryImpl() {
        weapons = new ArrayList<Weapon>() {{
            add(new Axe(10, 15));
            add(new Axe(20, 35));
            add(new Axe(40, 65));
        }};
    }

    public List<Weapon> getInventory() {
        return this.weapons;
    }

    public Weapon getWeapon() {
        Random rnd = new Random();

        int index = rnd.nextInt(this.weapons.size());

        return this.weapons.get(index);
    }
}
