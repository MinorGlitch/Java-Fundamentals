package database;

import models.boats.IBoat;
import models.engines.IEngine;
import contracts.IRepository;
import models.MotorBoat;

public class BoatSimulatorDatabase {
    private IRepository<IBoat> boats;
    private IRepository<IEngine> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new Repository<>());
        this.setEngines(new Repository<>());
    }

    public IRepository<IBoat> getBoats() {
        return this.boats;
    }

    private void setBoats(IRepository<IBoat> boats) {
        this.boats = boats;
    }

    public IRepository<IEngine> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<IEngine> engines) {
        this.engines = engines;
    }
}
