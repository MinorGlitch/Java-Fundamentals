package models.engines;

import Utility.Constants;
import Utility.Validator;

public abstract class BaseEngine implements IEngine {
    private String model;

    private int horsepower;

    private int displacement;

    protected BaseEngine(String model, int horsepower, int displacement) {
        this.setHorsepower(horsepower);
        this.setModel(model);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }
    @Override
    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public int getDisplacement() {
        return this.displacement;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
