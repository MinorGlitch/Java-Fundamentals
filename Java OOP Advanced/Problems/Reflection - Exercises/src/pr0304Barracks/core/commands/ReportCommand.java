package pr0304Barracks.core.commands;

import pr0304Barracks.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class ReportCommand extends BaseCommand {
    @Inject
    private Repository repository;

    public ReportCommand() {

    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
