package enumeration;

public enum  BoatType {
    ROW,
    POWER,
    SAIL,
    YACHT;


    @Override
    public String toString() {
        if (this.equals(BoatType.YACHT)) {
            return "Yacht";
        }

        return this.capitalize(this.name()) + " boat";
    }

    private String capitalize(String type) {
        return type.charAt(0) + type.substring(1).toLowerCase();
    }
}
