package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

public class MasterAgent extends BaseAgent implements BountyAgent {
    private Double bounty;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.setBounty(0.0D);
    }

    private void setBounty(Double bounty) {
        this.bounty = bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String toString() {
        return String.format("%s Agent - %s%n%sBounty Earned: $%.2f",
                "Master",
                this.getName(),
                super.toString(),
                this.getBounty());
    }
}
