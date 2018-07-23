package infernoInfinity.factories;

import infernoInfinity.Weapon;
import infernoInfinity.enums.WeaponType;

public class WeaponFactory {
    public static Weapon createWeapon(String type, String name) {
        WeaponType weaponType = Enum.valueOf(WeaponType.class, type.toUpperCase());

        switch (weaponType) {
            case AXE:
                return new Weapon(name, WeaponType.AXE);
            case KNIFE:
                return new Weapon(name, WeaponType.KNIFE);
            case SWORD:
                return new Weapon(name, WeaponType.SWORD);
            default:
                return null;
        }
    }
}
