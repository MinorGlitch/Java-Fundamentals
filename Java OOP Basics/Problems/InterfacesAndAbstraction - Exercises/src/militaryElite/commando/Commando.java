package militaryElite.commando;

import militaryElite.mission.Mission;
import militaryElite.specialisedSoldier.SpecialisedSoldier;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Commando extends SpecialisedSoldier implements ICommando {
    private Set<Mission> missions;

    public Commando(String id, String firstName, String lastName,
                       double salary, String corpses, List<String> missionArgs) {

        super(id, firstName, lastName, salary, corpses);
        this.missions = new LinkedHashSet<>();
        this.createMissions(missionArgs);
    }

    private void createMissions(List<String> missionArgs) {
        for (int i = 1; i < missionArgs.size(); i++) {
            try {
                missions.add(new Mission(missionArgs.get(i - 1), missionArgs.get(i)));
            } catch (IllegalArgumentException ignored) {

            }
        }
    }

    @Override
    public Set<Mission> getMissions() {
        return Collections.unmodifiableSet(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(this.getCorpses())
                .append(System.lineSeparator())
                .append("Missions:");


        if (this.getMissions().size() != 0) {
            sb.append(System.lineSeparator());
            missions.forEach(p -> sb.append("  ").append(p.toString()).append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }
}
