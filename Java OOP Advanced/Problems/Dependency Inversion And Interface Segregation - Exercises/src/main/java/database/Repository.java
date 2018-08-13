package database;

import Utility.Constants;
import contracts.IModel;
import models.engines.IEngine;
import contracts.IRepository;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class Repository<T extends IModel> implements IRepository<T> {
    private Map<String, T> itemsByModel;

    public Repository()
    {
        this.setItemsByModel(new HashMap<>());
    }

    public Map<String, T> getItemsByModel() {
        return this.itemsByModel;
    }

    private void setItemsByModel(HashMap<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void Add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel()))
        {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model))
        {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

}
