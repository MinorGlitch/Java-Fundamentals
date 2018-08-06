package models.races;

import exceptions.DuplicateModelException;
import models.boats.IBoat;

import java.util.List;

public interface IRace
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean allowsMotorboats();

    void AddParticipant(IBoat boat) throws DuplicateModelException;

    List<IBoat> GetParticipants();
}
