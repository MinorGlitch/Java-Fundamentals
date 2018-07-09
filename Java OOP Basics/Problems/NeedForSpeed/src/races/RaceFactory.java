package races;

public final class RaceFactory {
    public static Race createRace(String type, int length, String route, int prizePool) {
        RaceType raceType = RaceType.valueOf(type.toUpperCase());

        switch (raceType) {
            case DRAG:
                return new DragRace(length, route, prizePool);
            case DRIFT:
                return new DriftRace(length, route, prizePool);
            case CASUAL:
                return new CasualRace(length, route, prizePool);
            default:
                return null;
        }
    }
}
