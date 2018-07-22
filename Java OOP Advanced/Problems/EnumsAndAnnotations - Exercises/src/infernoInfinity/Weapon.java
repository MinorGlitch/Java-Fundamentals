package infernoInfinity;

@CustomAnnotation(description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        author = "Pesho", revision = 3, reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon> {
    private String name;
    private WeaponType weaponType;

    public Weapon(String name, WeaponType weaponType) {
        this.name = name;
        this.weaponType = weaponType;
    }

    public void removeNoWeaken(int index) {
        this.weaponType.getGems()[index] = null;
    }

    public void addGem(Gem gem, int index) {
        try {
            if (this.weaponType.getGems()[index] != null) {
                this.removeGem(index);
            }
            this.weaponType.getGems()[index] = gem;
            empowerWeapon(index);
        } catch (Exception ignored) {

        }
    }

    private void empowerWeapon(int index) {
        Gem gem = this.weaponType.getGems()[index];

        this.weaponType.setMinDamage(this.weaponType.getMinDamage() + gem.getStrength() * 2);
        this.weaponType.setMinDamage(this.weaponType.getMinDamage() + gem.getAgility());
        this.weaponType.setMaxDamage(this.weaponType.getMaxDamage() + gem.getStrength() * 3);
        this.weaponType.setMaxDamage(this.weaponType.getMaxDamage() + gem.getAgility() * 4);
    }

    public void removeGem(int index) {
        try {
            weakenWeapon(index);
            this.weaponType.getGems()[index] = null;
        } catch (Exception ignored) {

        }
    }

    private void weakenWeapon(int index) {
        Gem gem = this.weaponType.getGems()[index];

        this.weaponType.setMinDamage(this.weaponType.getMinDamage() - gem.getStrength() * 2);
        this.weaponType.setMinDamage(this.weaponType.getMinDamage() - gem.getAgility());
        this.weaponType.setMaxDamage(this.weaponType.getMaxDamage() - gem.getStrength() * 3);
        this.weaponType.setMaxDamage(this.weaponType.getMaxDamage() - gem.getAgility() * 4);
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, " +
                        "+%d Strength, +%d Agility, +%d Vitality", this.name,
                this.weaponType.getMinDamage(), this.weaponType.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality());
    }

    private int getStrength() {
        int res = 0;

        try {
            for (Gem gem : this.weaponType.getGems()) {
                if (gem != null) {
                    res += gem.getStrength();
                }
            }
        } catch (Exception ignored) {
        }

        return res;
    }

    private int getAgility() {
        int res = 0;

        try {
            for (Gem gem : this.weaponType.getGems()) {
                if (gem != null) {
                    res += gem.getAgility();
                }
            }
        } catch (Exception ignored) {

        }

        return res;
    }

    private int getVitality() {
        int res = 0;

        try {
            for (Gem gem : this.weaponType.getGems()) {
                if (gem != null) {
                    res += gem.getVitality();
                }
            }
        } catch (Exception ignored) {

        }

        return res;
    }

    public double calculateLevel() {
        return ((this.weaponType.getMinDamage() + this.weaponType.getMaxDamage()) / 2.0) +
                this.getAgility() + this.getStrength() + this.getVitality();
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.calculateLevel(), o.calculateLevel());
    }
}
