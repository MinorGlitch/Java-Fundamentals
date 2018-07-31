package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(ATTACK, DURABILITY);
    }

    @Test
    public void weaponLosesDurabilityAfterAttack() {
        this.axe.attack(this.dummy);

        Assert.assertEquals("Wrong durability", DURABILITY - 1, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackingWithBrokenWeapon() {
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
