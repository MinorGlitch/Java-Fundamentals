package callofduty.domain.missions;

import static callofduty.domain.constants.MissionMultipliersConstants.*;

public class SurveillanceMission extends BaseMission {
    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected void setRating(Double rating) {
        rating -= rating * SURVEILLANCE_RATING_MULTIPLIER;
        super.setRating(rating);
    }

    @Override
    protected void setBounty(Double bounty) {
        bounty += bounty * SURVEILLANCE_BOUNTY_MULTIPLIER;
        super.setBounty(bounty);
    }
}
