import Core.CommandHandler;
import Core.Engine;
import contracts.IBoatSimulatorController;
import contracts.ICommandHandler;
import controllers.BoatSimulatorController;
import database.BoatSimulatorDatabase;
import factories.boatFactories.BoatFactory;
import factories.engineFactories.EngineFactory;

public class Main {
    public static void main(String[] args) {
        BoatSimulatorDatabase db = new BoatSimulatorDatabase();
        IBoatSimulatorController ctrl = new BoatSimulatorController(db, new EngineFactory(),
                new BoatFactory(db.getEngines()));

        ICommandHandler commandHandler = new CommandHandler(ctrl);
        Engine engine = new Engine(commandHandler);
        engine.Run();
    }
}
