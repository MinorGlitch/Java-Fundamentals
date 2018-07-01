package mooD3;

public class Demon extends BaseCharacter {
    public Demon(String username, String type, int level, double specialPoints) {
        super(username, type, level, specialPoints);
        super.type = "Demon";
        super.setHashedPassword(type, username);
    }

    @Override
    public String toString() {
        return super.toString() + super.getSpecialPoints();
    }
}
