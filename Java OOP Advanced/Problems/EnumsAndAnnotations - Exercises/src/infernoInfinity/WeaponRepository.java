package infernoInfinity;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeaponRepository {
    private Map<String, Weapon> weapons;

    public WeaponRepository() {
        this.weapons = new LinkedHashMap<>();
    }

    public Map<String, Weapon> getWeapons() {
        return weapons;
    }
}
