package ferrari;

public class Ferrari implements Car {
    private static final String CAR_MODEL = "488-Spider";
    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return CAR_MODEL;
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String drive() {
        return "Zadu6avam sA!";
    }

    @Override
    public String brake() {
        return "Brakes!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.getModel(), this.brake(), this.drive(), this.getDriverName());
    }
}
