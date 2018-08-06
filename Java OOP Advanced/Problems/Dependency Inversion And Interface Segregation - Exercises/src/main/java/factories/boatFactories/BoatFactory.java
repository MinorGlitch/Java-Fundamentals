package factories.boatFactories;

import Utility.Validator;
import contracts.IRepository;
import enumeration.BoatType;
import exceptions.NonExistantModelException;
import models.boats.*;
import models.engines.IEngine;

import java.util.ArrayList;
import java.util.List;

public class BoatFactory implements IBoatFactory {
    private IRepository<IEngine> engineIRepository;

    public BoatFactory(IRepository<IEngine> engineIRepository) {
        this.engineIRepository = engineIRepository;
    }

    @Override
    public IBoat create(List<String> parameters, BoatType boatType) throws NonExistantModelException {
        IEngine engine;
        IEngine secondaryEngine;

        switch (boatType) {
            case YACHT:
                engine = this.engineIRepository.GetItem(parameters.get(2));

                return new Yacht(parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        engine,
                        Integer.parseInt(parameters.get(3)));
            case ROW:
                return new RowBoat(parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case SAIL:
                return new SailBoat(parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case POWER:
                engine = this.engineIRepository.GetItem(parameters.get(2));
                secondaryEngine = this.engineIRepository.GetItem(parameters.get(3));
                List<IEngine> engines = new ArrayList<>() {{
                    add(engine);
                    add(secondaryEngine);
                }};
                return new PowerBoat(parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        engines);
            default:
                return null;
        }
    }
}
