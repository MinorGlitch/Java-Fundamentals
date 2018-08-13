package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAgent implements Agent {
    private String id;
    private String name;
    private Double rating;
    private List<Mission> acceptedMissions;
    private List<Mission> completedMissions;

    protected BaseAgent(String id, String name, Double rating) {
        this.setId(id);
        this.setName(name);
        this.setRating(rating);
        this.setAcceptedMissions(new ArrayList<>());
        this.setCompletedMissions(new ArrayList<>());
    }

    @Override
    public void acceptMission(Mission mission) {
        this.acceptedMissions.add(mission);
    }

    @Override
    public void completeMissions() {
        for (Mission acceptedMission : acceptedMissions) {
            this.setRating(this.getRating() + acceptedMission.getRating());
            if (this instanceof MasterAgent) {
                try {
                    Field bountyField = MasterAgent.class.getDeclaredField("bounty");
                    bountyField.setAccessible(true);
                    bountyField.set(this, ((MasterAgent) this).getBounty() + acceptedMission.getBounty());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        this.completedMissions.addAll(this.acceptedMissions);
        this.acceptedMissions.clear();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRating(Double rating) {
        this.rating = rating;
    }

    private void setAcceptedMissions(List<Mission> acceptedMissions) {
        this.acceptedMissions = acceptedMissions;
    }

    private void setCompletedMissions(List<Mission> completedMissions) {
        this.completedMissions = completedMissions;
    }

    @Override
    public String toString() {
        return String.format(
                "Personal Code: %s\n" +
                        "Assigned Missions: %d\n" +
                        "Completed Missions: %d\n" +
                        "Rating: %.2f\n",

                this.getId(),
                this.acceptedMissions.size(),
                this.completedMissions.size(),
                this.rating);
    }
}
