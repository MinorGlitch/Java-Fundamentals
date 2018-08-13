package callofduty.domain.missions;

import static callofduty.domain.constants.MissionMultipliersConstants.*;

public class EscortMission extends BaseMission {
    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected void setRating(Double rating) {
        rating -= rating * ESCORT_RATING_MULTIPLIER;
        super.setRating(rating);
    }

    @Override
    protected void setBounty(Double bounty) {
        bounty += bounty * ESCORT_BOUNTY_MULTIPLIER;
        super.setBounty(bounty);
    }
}
