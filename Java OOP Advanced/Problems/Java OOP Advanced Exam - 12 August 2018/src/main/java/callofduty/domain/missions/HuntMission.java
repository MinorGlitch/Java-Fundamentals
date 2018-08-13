package callofduty.domain.missions;

import static callofduty.domain.constants.MissionMultipliersConstants.*;

public class HuntMission extends BaseMission {
    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected void setRating(Double rating) {
        rating += rating * HUNT_RATING_MULTIPLIER;
        super.setRating(rating);
    }

    @Override
    protected void setBounty(Double bounty) {
        bounty += bounty * HUNT_BOUNTY_MULTIPLIER;
        super.setBounty(bounty);
    }
}
