package infernoInfinity;

public enum Weapon {
    AXE(5, 10, new Gem[4]), SWORD(4, 6, new Gem[3]), KNIFE(3, 4, new Gem[2]);

    private int minDamage;
    private int maxDamage;
    private Gem[] gems;

    Weapon(int min, int max, Gem[] gems) {
        this.minDamage = min;
        this.maxDamage = max;
        this.gems = gems;
    }

    public void addGem(Gem gem, int index) {
        try {
            if (gems[index] != null) {
                weakenWeapon(index);
                gems[index] = gem;
                return;
            }

            empowerWeapon(gem);
            gems[index] = gem;

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }

    private void empowerWeapon(Gem gem) {
        this.minDamage += (gem.getStrength() * 2);
        this.minDamage +=  (gem.getAgility());
        this.maxDamage += (gem.getStrength() * 3);
        this.maxDamage += (gem.getAgility() * 4);
    }

    public void removeGem(int index) {
        try {
            if (gems[index] == null) {
                return;
            }
            weakenWeapon(index);

            gems[index] = null;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }

    private void weakenWeapon(int index) {
        Gem gem = this.gems[index];

        this.minDamage -= (gem.getStrength() * 2);
        this.minDamage -= (gem.getAgility());
        this.maxDamage -= (gem.getStrength() * 3);
        this.maxDamage -= (gem.getAgility() * 4);
    }

    @Override
    public String toString() {
        return String.format("%d-%d Damage, " +
                "+%d Strength, +%d Agility, +%d Vitality",
                this.minDamage, this.maxDamage, this.getStrength(), this.getAgility(), this.getVitality());
    }

    private int getStrength() {
        int res = 0;

        try {
            for (Gem gem : gems) {
                res += gem.getStrength();
            }
        } catch (Exception ignored) {}

        return res;
    }

    private int getAgility() {
        int res = 0;

        try {
            for (Gem gem : gems) {
                res += gem.getAgility();
            }
        } catch (Exception ignored) {

        }

        return res;
    }

    private int getVitality() {
        int res = 0;

        try {
            for (Gem gem : gems) {
                res += gem.getVitality();
            }
        } catch (Exception ignored) {

        }

        return res;
    }
}
