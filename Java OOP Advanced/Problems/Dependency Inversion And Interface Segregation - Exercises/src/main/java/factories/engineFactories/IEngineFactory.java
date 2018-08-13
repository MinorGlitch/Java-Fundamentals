package factories.engineFactories;

import enumeration.EngineType;
import models.engines.IEngine;

public interface IEngineFactory<T> {
    IEngine createEngine(String model, int horsepower, int displacement, EngineType engineType);
}
