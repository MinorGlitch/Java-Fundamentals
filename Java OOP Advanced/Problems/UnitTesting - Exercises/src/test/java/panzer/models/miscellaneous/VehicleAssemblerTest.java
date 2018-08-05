package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {
    private Assembler vehicleAssembler;
    private AttackModifyingPart attackModifyingPart;
    private DefenseModifyingPart defenseModifyingPart;
    private HitPointsModifyingPart hitPointsModifyingPart;


    @Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
        this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
    }

    @Test
    public void getTotalWeight() {
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(10.0);

        double actualTotalWeight = this.vehicleAssembler.getTotalWeight();
        double expectedTotalWeight = 30.0;

        Assert.assertEquals(expectedTotalWeight, actualTotalWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);

        BigDecimal actualTotalPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.ZERO.add(BigDecimal.ONE).add(BigDecimal.TEN);

        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void getTotalAttackModification() {
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(10);


        long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
        long expectedTotalAttackModification = 10;

        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(10);


        long actualTotalDefenseModification = this.vehicleAssembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = 10;

        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(10);

        long actualTotalHitPointModification = this.vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitPointModification = 10;

        Assert.assertEquals(expectedTotalHitPointModification, actualTotalHitPointModification);
    }

    @Test
    public void testEndurancePartsSum() {
        Assembler vehicleAssembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        vehicleAssembler.addEndurancePart(part1);
        vehicleAssembler.addEndurancePart(part2);

        long expected = Long.sum(Integer.MAX_VALUE, Integer.MAX_VALUE);

        long actual = vehicleAssembler.getTotalHitPointModification();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArsenalPartsSum() {
        Assembler vehicleAssembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        vehicleAssembler.addArsenalPart(part1);
        vehicleAssembler.addArsenalPart(part2);

        long expected = Long.sum(Integer.MAX_VALUE, Integer.MAX_VALUE);

        long actual = vehicleAssembler.getTotalAttackModification();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDefencePartsSum() {
        Assembler vehicleAssembler = new VehicleAssembler();
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        vehicleAssembler.addShellPart(part1);
        vehicleAssembler.addShellPart(part2);

        long expected = Long.sum(Integer.MAX_VALUE, Integer.MAX_VALUE);

        long actual = vehicleAssembler.getTotalDefenseModification();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addArsenalPart() {
        Assembler vehicleAssembler = new VehicleAssembler();
        Part part1 = Mockito.mock(AttackModifyingPart.class);
        Part part2 = Mockito.mock(AttackModifyingPart.class);

        vehicleAssembler.addArsenalPart(part1);
        vehicleAssembler.addArsenalPart(part2);

        int actualSize = 0;

        try {
            Field arsenalPartsField = vehicleAssembler.getClass().getDeclaredField("arsenalParts");
            arsenalPartsField.setAccessible(true);

            List<AttackModifyingPart> attackModifyingParts =
                    (List<AttackModifyingPart>) arsenalPartsField.get(vehicleAssembler);

            actualSize = attackModifyingParts.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 2;

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addShellPart() {
        Assembler vehicleAssembler = new VehicleAssembler();
        Part part1 = Mockito.mock(DefenseModifyingPart.class);
        Part part2 = Mockito.mock(DefenseModifyingPart.class);

        vehicleAssembler.addShellPart(part1);
        vehicleAssembler.addShellPart(part2);

        int actualSize = 0;

        try {
            Field shellPartsField = vehicleAssembler.getClass().getDeclaredField("shellParts");
            shellPartsField.setAccessible(true);

            List<DefenseModifyingPart> defenseModifyingParts =
                    (List<DefenseModifyingPart>) shellPartsField.get(vehicleAssembler);

            actualSize = defenseModifyingParts.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 2;

        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void addEndurancePart() {
        Assembler vehicleAssembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        vehicleAssembler.addEndurancePart(part1);
        vehicleAssembler.addEndurancePart(part2);

        int actualSize = 0;

        try {
            Field endurancePartsField = vehicleAssembler.getClass().getDeclaredField("enduranceParts");
            endurancePartsField.setAccessible(true);

            List<HitPointsModifyingPart> hitPointsModifyingParts =
                    (List<HitPointsModifyingPart>) endurancePartsField.get(vehicleAssembler);

            actualSize = hitPointsModifyingParts.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 2;

        Assert.assertEquals(expectedSize, actualSize);

    }
}