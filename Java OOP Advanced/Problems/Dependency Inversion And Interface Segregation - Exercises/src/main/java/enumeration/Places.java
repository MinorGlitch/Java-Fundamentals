package enumeration;

public enum Places {
    FIRST,
    SECOND,
    THIRD;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
