package models.boats;

import models.engines.IEngine;

import java.util.List;

public interface IPowerBoat extends IBoat {
    List<IEngine> getEngines();
}
