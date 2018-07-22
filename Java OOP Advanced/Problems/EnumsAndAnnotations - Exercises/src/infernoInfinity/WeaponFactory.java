package infernoInfinity;

public class WeaponFactory {
    public static Weapon createWeapon(String type) {
        Weapon weapon = Enum.valueOf(Weapon.class, type.toUpperCase());

        switch (weapon) {
            case AXE:
                return Weapon.AXE;
            case KNIFE:
                return Weapon.KNIFE;
            case SWORD:
                return Weapon.SWORD;
            default:
                return null;
        }
    }
}
