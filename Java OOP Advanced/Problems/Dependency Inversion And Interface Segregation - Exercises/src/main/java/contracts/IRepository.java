package contracts;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.engines.IEngine;

public interface IRepository<T> {
    void Add(T item) throws DuplicateModelException;

    T GetItem(String model) throws NonExistantModelException;
}
