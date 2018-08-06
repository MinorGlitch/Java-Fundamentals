package factories.engineFactories;

import models.engines.IEngine;
import enumeration.EngineType;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;

public class EngineFactory implements IEngineFactory {
    @Override
    public IEngine createEngine(String model, int horsepower, int displacement, EngineType engineType) {
        switch (engineType) {
            case JET:
                return new JetEngine(model, horsepower, displacement);
            case STERNDRIVE:
                return new SterndriveEngine(model, horsepower, displacement);
            default:
                throw new NoSuchMethodError();
        }
    }
}
