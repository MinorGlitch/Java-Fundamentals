package factories.boatFactories;

import enumeration.BoatType;
import exceptions.NonExistantModelException;
import models.boats.IBoat;

import java.util.List;

public interface IBoatFactory {
    IBoat create(List<String> args, BoatType boatType) throws NonExistantModelException;
}
