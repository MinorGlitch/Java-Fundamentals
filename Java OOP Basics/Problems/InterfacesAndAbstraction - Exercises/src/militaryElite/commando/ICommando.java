package militaryElite.commando;

import militaryElite.mission.Mission;
import militaryElite.specialisedSoldier.ISpecialisedSoldier;

import java.util.Set;

public interface ICommando extends ISpecialisedSoldier {
    Set<Mission> getMissions();
}
