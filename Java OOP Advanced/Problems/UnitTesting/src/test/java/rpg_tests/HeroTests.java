package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {
    private static final int DUMMY_EXPERIENCE = 15;
    private static final int AXE_ATTACK_POINTS = 10;

    private Weapon axeMock;
    private Target dummyMock;

    @Before
    public void createMockedEntities() {
        axeMock = Mockito.mock(Axe.class);
        Mockito.when(this.axeMock.getAttackPoints()).thenReturn(AXE_ATTACK_POINTS);

        dummyMock = Mockito.mock(Dummy.class);
        Mockito.when(this.dummyMock.isDead()).thenReturn(true);
        Mockito.when(this.dummyMock.giveExperience()).thenReturn(DUMMY_EXPERIENCE);

    }

    @Test
    public void heroGainsXP() {
        Hero hero = new Hero("Peshi", this.axeMock);

        hero.attack(this.dummyMock);

        Assert.assertEquals("Wrong Experience", DUMMY_EXPERIENCE, hero.getExperience());
    }

    @Test
    public void heroGetsLootAfterDummyDies() {
        Target target = new Dummy(0, 0);

        Weapon weapon = target.giveWeapon();

        Assert.assertNotNull(weapon);
    }
}
