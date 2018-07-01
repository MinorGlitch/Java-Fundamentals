package mooD3;

public abstract class BaseCharacter implements GameObject {
    private String username;
    private String hashedPassword;
    private int level;
    private double specialPoints;

    protected String type;

    protected BaseCharacter(String username, String type, int level, double specialPoints) {
        this.username = username;
        this.level = level;
        this.type = type;
        this.specialPoints = specialPoints;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public double getSpecialPoints() {
        return this.specialPoints * this.level;
    }

    protected void setHashedPassword(String type, String username) {
        if (type.equals("Demon")) {
            this.hashedPassword = hashDemon(username);
        } else {
            this.hashedPassword = hashArchangel(username);
        }
    }

    private String hashArchangel(String username) {
        return this.reverseName(username) + (username.length() * 21);
    }

    private String reverseName(String username) {
        return new StringBuilder(username).reverse().toString();
    }

    private String hashDemon(String username) {
        return String.valueOf(username.length() * 217);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n", this.username, this.getHashedPassword(), this.type);
    }
}
