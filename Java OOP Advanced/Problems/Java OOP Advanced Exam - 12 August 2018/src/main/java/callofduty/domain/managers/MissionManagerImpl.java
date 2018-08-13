package callofduty.domain.managers;

import callofduty.domain.agents.BaseAgent;
import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.domain.enums.MissionStatus;
import callofduty.domain.missions.BaseMission;
import callofduty.interfaces.*;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static callofduty.domain.constants.MissionManagerConstants.*;

public class MissionManagerImpl implements MissionManager {
    private Map<String, Agent> agents;
    private MissionControl missionControl;
    private Map<String, Mission> missions;

    public MissionManagerImpl(MissionControl missionControl) {
        this.agents = new LinkedHashMap<>();
        this.missionControl = missionControl;
        this.missions = new LinkedHashMap<>();
    }

    @Override
    public String agent(List<String> arguments) {
        Agent agent = new NoviceAgent(arguments.get(0), arguments.get(1));

        this.agents.put(agent.getId(), agent);

        return String.format(AGENT_COMMAND_OUTPUT_MESSAGE, agent.getName(), agent.getId());
    }

    @Override
    public String request(List<String> arguments) {
        Mission mission = this.missionControl.generateMission(arguments.get(1),
                Double.valueOf(arguments.get(2)), Double.valueOf(arguments.get(3)));

        Agent agent = this.agents.get(arguments.get(0));

        agent.acceptMission(mission);

        this.setAssignedMissionFlag(agent);

        this.missions.put(mission.getId(), mission);

        return String.format(REQUEST_COMMAND_OUTPUT_MESSAGE,
                mission.getClass().getSimpleName().substring(0, mission.getClass().getSimpleName().indexOf("Mission")),
                mission.getId(),
                agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {
        Agent agent = this.agents.get(arguments.get(0));
        agent.completeMissions();

        this.setCompletedMissionsFlag(agent);

        if (agent instanceof NoviceAgent && this.getCompletedMissionsCount() >= 3) {
            this.agents.put(agent.getId(), this.createMasterAgent(agent));
        }

        return String.format(COMPLETE_COMMAND_OUTPUT_MESSAGE,
                agent.getName(),
                agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        if (this.agents.containsKey(arguments.get(0))) {
            sb.append(this.agents.get(arguments.get(0))).append(System.lineSeparator());
        }

        if (this.missions.containsKey(arguments.get(0))) {
            sb.append(this.missions.get(arguments.get(0))).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String over(List<String> arguments) {
        return this.toString();
    }

    @Override
    public String toString() {
        return String.format("Novice Agents: %d\n" +
                        "Master Agents: %d\n" +
                        "Assigned Missions: %d\n" +
                        "Completed Missions: %d\n" +
                        "Total Rating Given: %.2f\n" +
                        "Total Bounty Given: $%.2f\n",
                this.getNoviceAgentsCount(),
                this.getMasterAgentsCount(),
                this.getAllMissionsCount(),
                this.getCompletedMissionsCount(),
                this.getTotalRating(),
                this.getTotalBounty());
    }

    private double getTotalBounty() {
        return this.agents.values().stream()
                .filter(a -> a instanceof MasterAgent)
                .mapToDouble(a -> ((MasterAgent) a).getBounty())
                .sum();
    }

    private int getNoviceAgentsCount() {
        return (int) this.agents.values().stream().filter(a -> a instanceof NoviceAgent).count();
    }

    private int getMasterAgentsCount() {
        return (int) this.agents.values().stream().filter(a -> a instanceof MasterAgent).count();
    }

    private int getCompletedMissionsCount() {
        int sum = 0;

        for (Agent agent : this.agents.values()) {

            List<Mission> missions = this.getCompletedMissions(agent);

            sum += missions.size();

        }

        return sum;
    }

    private double getTotalRating() {
        return this.missions.values().stream().mapToDouble(Rateable::getRating).sum();
    }

    private int getAllMissionsCount() {
        int sum = this.getCompletedMissionsCount();

        for (Agent agent : this.agents.values()) {
            try {
                Field completedField = BaseAgent.class.getDeclaredField("acceptedMissions");
                completedField.setAccessible(true);

                List<Mission> missions = (List<Mission>) completedField.get(agent);

                sum += missions.size();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sum;
    }

    private List<Mission> getCompletedMissions(Agent agent) {
        try {
            Field field = BaseAgent.class.getDeclaredField("completedMissions");
            field.setAccessible(true);

            return (List<Mission>) field.get(agent);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Mission> getAssignedMissions(Agent agent) {
        try {
            Field field = BaseAgent.class.getDeclaredField("acceptedMissions");
            field.setAccessible(true);

            return (List<Mission>) field.get(agent);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setAssignedMissionFlag(Agent agent) {
        this.getAssignedMissions(agent).forEach(m -> {
            try {
                Field flagField = BaseMission.class.getDeclaredField("status");
                flagField.setAccessible(true);
                flagField.set(m, MissionStatus.OPEN.toString());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private void setCompletedMissionsFlag(Agent agent) {
        this.getCompletedMissions(agent).forEach(m -> {
            try {
                Field flagField = BaseMission.class.getDeclaredField("status");
                flagField.setAccessible(true);
                flagField.set(m, MissionStatus.COMPLETED.toString());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private Agent createMasterAgent(Agent agent) {
        Agent master = new MasterAgent(agent.getId(), agent.getName(), agent.getRating());

        try {
            Field completed = BaseAgent.class.getDeclaredField("completedMissions");
            completed.setAccessible(true);

            List<Mission> sourceMissions = (List<Mission>) completed.get(agent);
            completed.set(master, sourceMissions);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return master;
    }
}
