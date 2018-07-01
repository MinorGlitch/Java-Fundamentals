package mooD3;

public class Archangel extends BaseCharacter {
    public Archangel(String username, String type, int level, double specialPoints) {
        super(username, type, level, specialPoints);
        super.type = "Archangel";
        super.setHashedPassword(type, username);
    }

    @Override
    public String toString() {
        return super.toString() + (int) super.getSpecialPoints();
    }
}
