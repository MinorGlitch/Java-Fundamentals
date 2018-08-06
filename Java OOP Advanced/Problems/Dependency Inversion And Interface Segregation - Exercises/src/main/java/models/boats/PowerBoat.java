package models.boats;

import models.engines.IEngine;
import models.races.IRace;

import java.util.List;

public class PowerBoat extends BaseBoat implements IPowerBoat {
    private List<IEngine> engines;

    public PowerBoat(String model, int weight, List<IEngine> engines) {
        super(model, weight);
        this.setEngines(engines);
    }

    private void setEngines(List<IEngine> engines) {

        this.engines = engines;
    }

    @Override
    public List<IEngine> getEngines() {
        return engines;
    }

    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public Double CalculateRaceSpeed(IRace currentRace) {
        double res = 0.0D;

        for (IEngine engine : this.engines) {
            res += engine.getOutput();
        }

        return res - super.getWeight() + (currentRace.getOceanCurrentSpeed() / 5.0);
    }
}
