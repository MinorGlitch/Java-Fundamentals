package models.boats;

import Utility.Validator;
import models.races.IRace;

public class RowBoat extends BaseBoat implements IRowBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public int getOars() {
        return this.oars;
    }

    @Override
    public Double CalculateRaceSpeed(IRace currentRace) {
        return (this.oars * 100.0) - super.getWeight() + currentRace.getOceanCurrentSpeed();
    }
}
