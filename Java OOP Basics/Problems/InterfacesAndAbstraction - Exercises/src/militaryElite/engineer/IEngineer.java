package militaryElite.engineer;

import militaryElite.repair.Repair;
import militaryElite.specialisedSoldier.ISpecialisedSoldier;

import java.util.Set;

public interface IEngineer extends ISpecialisedSoldier {
    Set<Repair> getRepairs();
}
