package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class FightCommand extends BaseCommand {
    public FightCommand() {

    }

    @Override
    public String execute() {
        return "fight";
    }
}
