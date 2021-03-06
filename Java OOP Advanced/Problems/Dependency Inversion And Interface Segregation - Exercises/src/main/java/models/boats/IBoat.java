package models.boats;

import contracts.IModel;
import models.races.IRace;

public interface IBoat extends IModel {
    int getWeight();
    boolean isMotorized();
    double CalculateRaceSpeed(IRace currentRace);
}
