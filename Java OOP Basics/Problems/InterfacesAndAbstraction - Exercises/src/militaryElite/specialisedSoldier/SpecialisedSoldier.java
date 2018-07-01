package militaryElite.specialisedSoldier;

import militaryElite.leutenantGeneral.LieutenantGeneral;
import militaryElite.privateSoldier.IPrivate;
import militaryElite.privateSoldier.Private;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private String corpses;

    private static final String MARINES = "Marines";
    private static final String AIRFORCES = "Airforces";

    protected SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corpses) {
        super(id, firstName, lastName, salary);
        this.setCorpses(corpses);
    }

    private void setCorpses(String corpses) {
        if (!corpses.equals(MARINES) && !corpses.equals(AIRFORCES)) {
            throw new IllegalArgumentException("Invalid corpses");
        }

        this.corpses = corpses;
    }

    @Override
    public String getCorpses() {
        return this.corpses;
    }
}
