package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class RetireCommand extends BaseCommand {
    @Inject
    private Repository repository;

    @Inject
    private String[] data;

    public RetireCommand() {
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
