package models.boats;

import models.engines.IEngine;

public interface IYacht extends IBoat {
    IEngine getEngine();
    int getCargoWeight();
}
