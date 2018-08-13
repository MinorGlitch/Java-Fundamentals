package contracts;

import database.BoatSimulatorDatabase;
import enumeration.BoatType;
import enumeration.EngineType;
import exceptions.*;
import models.races.IRace;

import java.util.List;

public interface IBoatSimulatorController {
    IRace getCurrentRace();

    BoatSimulatorDatabase getDatabase();

    String CreateBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;

    String createBoat(List<String> parameters, BoatType boatType) throws NonExistantModelException, DuplicateModelException;

    String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String SignUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String StartRace() throws InsufficientContestantsException, NoSetRaceException;

    String GetStatistic();
}
