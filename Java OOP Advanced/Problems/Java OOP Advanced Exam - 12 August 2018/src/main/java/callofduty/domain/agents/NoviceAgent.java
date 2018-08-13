package callofduty.domain.agents;

public class NoviceAgent extends BaseAgent {
    public NoviceAgent(String id, String name) {
        super(id, name, 0.0D);
    }

    @Override
    public String toString() {
        return String.format("%s Agent - %s%n%s",
                "Novice",
                this.getName(),
                super.toString());
    }
}
