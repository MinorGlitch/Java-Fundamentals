package models.boats;

import Utility.Validator;
import models.engines.IEngine;
import models.races.IRace;

public class Yacht extends BaseBoat implements IYacht {
    private IEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, IEngine engine, int cargoWeight) {
        super(model, weight);
        this.setEngine(engine);
        this.setCargoWeight(cargoWeight);
    }

    private void setEngine(IEngine engine) {
        this.engine = engine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public IEngine getEngine() {
        return this.engine;
    }

    @Override
    public int getCargoWeight() {
        return this.cargoWeight;
    }

    @Override
    public double CalculateRaceSpeed(IRace currentRace) {
        return this.engine.getOutput() - super.getWeight() - this.cargoWeight +
                (currentRace.getOceanCurrentSpeed() / 2D);
    }

    @Override
    public boolean isMotorized() {
        return true;
    }
}
