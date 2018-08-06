package controllers;

import Utility.Constants;
import Utility.Validator;
import contracts.IBoatSimulatorController;
import enumeration.BoatType;
import enumeration.Places;
import factories.boatFactories.IBoatFactory;
import factories.engineFactories.IEngineFactory;
import models.boats.*;
import models.engines.IEngine;
import models.races.IRace;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exceptions.*;
import models.races.Race;

import javax.naming.OperationNotSupportedException;
import java.util.*;
import java.util.stream.Collectors;

import static Utility.Constants.*;

public class BoatSimulatorController implements IBoatSimulatorController {
    private Map<IBoat, Double> winners;
    private Map<IBoat, Double> notFinished;
    private BoatSimulatorDatabase database;
    private IRace currentRace;
    private IEngineFactory engineFactory;
    private IBoatFactory boatFactory;

    public BoatSimulatorController(BoatSimulatorDatabase database, IEngineFactory engineFactory, IBoatFactory boatFactory) {
        this.setDatabase(database);
        this.setCurrentRace(currentRace);
        this.engineFactory = engineFactory;
        this.boatFactory = boatFactory;
        this.winners = new LinkedHashMap<>();
        this.notFinished = new LinkedHashMap<>();
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    public void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public IRace getCurrentRace() {
        return this.currentRace;
    }

    public void setCurrentRace(IRace currentRace) {
        this.currentRace = currentRace;
    }

    @Override
    public String CreateBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        IEngine engine = this.engineFactory.createEngine(model, horsepower, displacement, engineType);

        this.database.getEngines().Add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    @Override
    public String createBoat(List<String> parameters, BoatType boatType) throws NonExistantModelException, DuplicateModelException {

        IBoat boat = this.boatFactory.create(parameters, boatType);
        Validator.ValidatePropertyValue(boat.getWeight(), "weight");
        this.database.getBoats().Add(boat);

        return String.format(Constants.CREATED_BOAT_MESSAGE, boatType.toString(), boat.getModel());
    }

    public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        IRace race = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.ValidateRaceIsEmpty();
        this.currentRace = race;
        return String.format(
                "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                distance, windSpeed, oceanCurrentSpeed);
    }

    public String SignUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        IBoat boat = this.database.getBoats().GetItem(model);
        this.ValidateRaceIsSet();
        //TODO

        if (boat == null) {
            throw new NonExistantModelException(NON_EXISTENT_MODEL_MESSAGE);
        }

        if (!this.currentRace.allowsMotorboats() && boat.isMotorized()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.AddParticipant(boat);

        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String StartRace() throws InsufficientContestantsException, NoSetRaceException {
        this.ValidateRaceIsSet();
        List<IBoat> participants = this.currentRace.GetParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        this.chooseWinners(participants);

        StringBuilder result = new StringBuilder();
        int places = 0;
        for (Map.Entry<IBoat, Double> winnersEntry : winners.entrySet()) {
            if (places >= 3) {
                break;
            }
            result.append(String.format("%s place: %s Model: %s Time: %s",
                    Places.values()[places++],
                    winnersEntry.getKey().getClass().getSimpleName(),
                    winnersEntry.getKey().getModel(),
                    isFinished(winnersEntry.getValue())))
                    .append(System.lineSeparator());
        }
        for (Map.Entry<IBoat, Double> notFinishedEntry : notFinished.entrySet()) {
            if (places >= 3) {
                break;
            }
            result.append(String.format("%s place: %s Model: %s Time: Did not finish!",
                    Places.values()[places++],
                    notFinishedEntry.getKey().getClass().getSimpleName(),
                    notFinishedEntry.getKey().getModel()))
                    .append(System.lineSeparator());
        }

        this.currentRace = null;
        this.winners.clear();
        this.notFinished.clear();

        return result.toString().trim();
    }

    private String isFinished(Double time) {
        if (time <= 0 || time == Double.POSITIVE_INFINITY || time == Double.NEGATIVE_INFINITY) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", time);
    }

    @Override
    public String GetStatistic() {
        Map<String, List<IBoat>> grouped = new LinkedHashMap<>();
        int totalSize = this.currentRace.GetParticipants().size();

        for (IBoat boat : this.currentRace.GetParticipants()) {
            grouped.putIfAbsent(boat.getClass().getSimpleName(), new ArrayList<>());
            grouped.get(boat.getClass().getSimpleName()).add(boat);
        }

        StringBuilder result = new StringBuilder();

        grouped = grouped
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, List<IBoat>> groupedSet : grouped.entrySet()) {
            double percent = ((double) groupedSet.getValue().size() / totalSize) * 100.0;

            result.append(String.format("%s -> %.2f%%", groupedSet.getKey(), percent))
            .append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    private void chooseWinners(List<IBoat> participants) {
        for (IBoat participant : participants) {
            Double speed = participant.CalculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if (time <= 0) {
                notFinished.put(participant, time);
            } else {
                winners.put(participant, time);
            }
        }

        this.winners = this.winners.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    private void ValidateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
