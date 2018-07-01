package militaryElite.engineer;

import militaryElite.repair.Repair;
import militaryElite.specialisedSoldier.SpecialisedSoldier;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private Set<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary,
                    String corpses, List<String> repairArgs) {
        super(id, firstName, lastName, salary, corpses);
        this.repairs = new LinkedHashSet<>();
        this.parseRepairArgs(repairArgs);
    }

    private void parseRepairArgs(List<String> repairArgs) {
        for (int i = 1; i < repairArgs.size(); i+= 2) {
            repairs.add(new Repair(repairArgs.get(i - 1), Integer.valueOf(repairArgs.get(i))));
        }
    }

    @Override
    public Set<Repair> getRepairs() {
        return Collections.unmodifiableSet(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(this.getCorpses())
                .append(System.lineSeparator())
                .append("Repairs:");

        if (this.getRepairs().size() != 0) {
            sb.append(System.lineSeparator());
            repairs.forEach(p -> sb.append("  ").append(p.toString()).append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }
}
