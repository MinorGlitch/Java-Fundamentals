package races;

import cars.Car;

import java.util.List;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public void calculatePerformance() {
        super.getParticipants().forEach(p -> {
            int points = (p.getHorsepower() / p.getAcceleration()) + (p.getSuspension() + p.getDurability());

            p.setPerformancePoints(points);
        });
    }

}
