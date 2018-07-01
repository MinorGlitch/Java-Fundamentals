package militaryElite.repair;

public class Repair implements IRepair{
    private String partName;
    private int repairHours;

    public Repair(String partName, int repairHours) {
        this.partName = partName;
        this.repairHours = repairHours;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getRepairHours() {
        return this.repairHours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getRepairHours());
    }
}
