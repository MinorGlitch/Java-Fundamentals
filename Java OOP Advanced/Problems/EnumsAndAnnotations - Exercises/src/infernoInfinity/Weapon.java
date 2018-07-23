package infernoInfinity;

@CustomAnnotation(description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        author = "Pesho", revision = 3, reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon> {
    private String name;
    private WeaponType weaponType;
    private int minDamage;
    private int maxDamage;
    private Gem[] gems;

    public Weapon(String name, WeaponType weaponType) {
        this.name = name;
        this.weaponType = weaponType;
        this.minDamage = this.weaponType.getMinDamage();
        this.maxDamage = this.weaponType.getMaxDamage();
        this.gems = new Gem[this.weaponType.getGems()];
    }

    public void addGem(Gem gem, int index) {
        try {
            this.gems[index] = gem;
        } catch (Exception ignored) {

        }
    }

    public void removeGem(int index) {
        try {
            this.gems[index] = null;
        } catch (Exception ignored) {

        }
    }

    private int getMinDamage() {
        return this.minDamage + this.getMinDamageBonus();
    }

    private int getMaxDamage() {
        return this.maxDamage + this.getMaxDamageBonus();
    }

    private int getMaxDamageBonus() {
        return (this.getStrength() * 3) + (this.getAgility() * 4);
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, " +
                        "+%d Strength, +%d Agility, +%d Vitality", this.name,
                this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality());
    }

    private int getMinDamageBonus() {
        return (this.getStrength() * 2) + this.getAgility();
    }

    private int getStrength() {
        int res = 0;

        try {
            for (Gem gem : this.gems) {
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
            for (Gem gem : this.gems) {
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
            for (Gem gem : this.gems) {
                if (gem != null) {
                    res += gem.getVitality();
                }
            }
        } catch (Exception ignored) {

        }

        return res;
    }

    public double calculateLevel() {
        return ((this.getMinDamage() + this.getMaxDamage()) / 2.0) +
                this.getAgility() + this.getStrength() + this.getVitality();
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.calculateLevel(), o.calculateLevel());
    }
}
