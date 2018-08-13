package callofduty.domain.enums;

public enum MissionStatus {
    OPEN,
    COMPLETED;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
