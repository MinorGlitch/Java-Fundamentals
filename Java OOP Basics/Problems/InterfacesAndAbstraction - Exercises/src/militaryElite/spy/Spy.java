package militaryElite.spy;

import militaryElite.soldier.BaseSoldier;

public class Spy extends BaseSoldier implements ISpy {
    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator())
                .append("Code Number: ")
                .append(this.getCodeNumber());

        return sb.toString();
    }
}
