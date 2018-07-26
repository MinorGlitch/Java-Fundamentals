package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends BaseCommand {
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    @Inject
    private String[] data;

    public AddCommand() {
}

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.unitFactory.createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
