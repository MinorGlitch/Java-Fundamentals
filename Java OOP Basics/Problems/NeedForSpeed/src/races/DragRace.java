package races;

import cars.Car;

import java.util.List;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public void calculatePerformance() {
        super.getParticipants().forEach(p -> {
            int points = (p.getHorsepower() / p.getAcceleration());

            p.setPerformancePoints(points);
        });
    }
}
