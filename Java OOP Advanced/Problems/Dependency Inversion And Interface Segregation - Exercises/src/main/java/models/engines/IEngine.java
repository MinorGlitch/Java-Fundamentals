package models.engines;

import contracts.IModel;

public interface IEngine extends IModel {
    int getOutput();
    int getHorsepower();
    int getDisplacement();

}
