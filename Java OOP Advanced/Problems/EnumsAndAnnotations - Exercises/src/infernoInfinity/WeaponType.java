package infernoInfinity;

public enum WeaponType {
    AXE(5, 10, new Gem[4]), SWORD(4, 6, new Gem[3]), KNIFE(3, 4, new Gem[2]);

    private int minDamage;
    private int maxDamage;
    private Gem[] gems;

    WeaponType(int min, int max, Gem[] gems) {
        this.minDamage = min;
        this.maxDamage = max;
        this.gems = gems;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public Gem[] getGems() {
        return gems;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}
