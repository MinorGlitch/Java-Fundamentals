package Core;

import Utility.Constants;
import contracts.IBoatSimulatorController;
import contracts.ICommandHandler;
import enumeration.BoatType;
import enumeration.EngineType;
import exceptions.*;

import java.util.List;

public class CommandHandler implements ICommandHandler {
    public IBoatSimulatorController controller;

    public CommandHandler(IBoatSimulatorController controller) {
        this.setController(controller);
    }

    public IBoatSimulatorController getController() {
        return this.controller;
    }

    private void setController(IBoatSimulatorController controller) {
        this.controller = controller;
    }

    public String ExecuteCommand(String name, List<String> parameters)
            throws DuplicateModelException, NonExistantModelException,
            RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                EngineType engineType = Enum.valueOf(EngineType.class, parameters.get(3).toUpperCase());

                switch (engineType) {
                    case JET:
                        return this.getController().CreateBoatEngine(
                                parameters.get(0),
                                Integer.parseInt(parameters.get(1)),
                                Integer.parseInt(parameters.get(2)),
                                engineType);
                    case STERNDRIVE:
                        return this.getController().CreateBoatEngine(
                                parameters.get(0),
                                Integer.parseInt(parameters.get(1)),
                                Integer.parseInt(parameters.get(2)),
                                engineType);
                    default:
                        throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
                }

            case "CreateRowBoat":
                return this.getController().createBoat(parameters, BoatType.ROW);
            case "CreateSailBoat":
                return this.getController().createBoat(parameters, BoatType.SAIL);
            case "CreatePowerBoat":
                return this.getController().createBoat(parameters, BoatType.POWER);
            case "CreateYacht":
                return this.getController().createBoat(parameters, BoatType.YACHT);
            case "OpenRace":
                return this.getController().OpenRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            case "SignUpBoat":
                return this.getController().SignUpBoat(parameters.get(0));
            case "StartRace":
                return this.getController().StartRace();
            case "GetStatistic":
                return this.getController().GetStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
