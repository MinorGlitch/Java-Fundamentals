package firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    private List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    private List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    @Override
    public String toString() {

        return "First team have " + this.getFirstTeam().size() + " players" + "\n" +
                "Reserve team have " + this.getReserveTeam().size() + " players";
    }
}
