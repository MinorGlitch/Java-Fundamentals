package races;

import cars.Car;

import java.util.List;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public void calculatePerformance() {
        super.getParticipants().forEach(p -> {
            int points = p.getSuspension() + p.getDurability();

            p.setPerformancePoints(points);
        });
    }
}
