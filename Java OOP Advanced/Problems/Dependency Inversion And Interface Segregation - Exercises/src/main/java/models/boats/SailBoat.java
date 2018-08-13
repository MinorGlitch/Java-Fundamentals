package models.boats;

import Utility.Constants;
import models.races.IRace;

public class SailBoat extends BaseBoat implements ISailBoat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public int getSailEfficiency() {
        return this.sailEfficiency;
    }

    @Override
    public double CalculateRaceSpeed(IRace currentRace) {
        return (currentRace.getWindSpeed() * (this.sailEfficiency / 100D)) -
                super.getWeight() + (currentRace.getOceanCurrentSpeed() / 2D);
    }
}
