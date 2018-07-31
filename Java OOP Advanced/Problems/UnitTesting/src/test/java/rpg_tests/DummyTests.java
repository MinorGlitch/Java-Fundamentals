package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int AXE_ATTACK = 5;
    private static final int AXE_DURABILITY = 5;
    private static final int DUMMY_ATTACK = 10;
    private static final int DUMMY_DURABILITY = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_ATTACK, DUMMY_DURABILITY);
    }

    @Test
    public void dummyLosesHealthAfterAttacked() {
        this.axe.attack(this.dummy);

        Assert.assertEquals(5, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void canDummyGiveExperience() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

        Assert.assertEquals(10, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void cantDummyGiveExperience() {
        this.axe.attack(this.dummy);

        this.dummy.giveExperience();
    }
}
