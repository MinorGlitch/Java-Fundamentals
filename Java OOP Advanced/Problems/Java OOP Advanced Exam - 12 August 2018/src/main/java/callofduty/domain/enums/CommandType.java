package callofduty.domain.enums;

public enum CommandType {
    AGENT,
    REQUEST,
    COMPLETE,
    STATUS,
    OVER;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
