package models.boats;

import Utility.Constants;
import Utility.Validator;

public abstract class BaseBoat implements IBoat {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    @Override
    public boolean isMotorized() {
        return false;
    }
}
