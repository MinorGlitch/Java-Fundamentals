package races;

import cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    public boolean isEmpty() {
        return participants.size() == 0;
    }

    public boolean containsCar(Car car) {
        return participants.contains(car);
    }

    protected void orderParticipants() {
        participants = participants.stream().sorted((a, b) -> {
            return b.getPerformancePoints() - a.getPerformancePoints();
        }).collect(Collectors.toList());
    }

    public void calculatePerformance() {

    }

    public String toString() {
        //o	“{route} - {length}
        //o	 1. {brand} {model} {performancePoints}PP - ${moneyWon}
        //o	 2. {brand} {model} {performancePoints}PP - ${moneyWon}
        //o	 3. {brand} {model} {performancePoints}PP - ${moneyWon}”

        StringBuilder sb = new StringBuilder();

        this.orderParticipants();
        sb.append(String.format("%s - %d%n", this.route, this.length));
        int prize;
        for (int i = 0; i < Math.min(this.participants.size(), 3); i++) {
            Car car = this.participants.get(i);

            if (i == 0) {
                prize = (int) (this.prizePool * 0.5);
            } else if (i == 1) {
                prize = (int) (this.prizePool * 0.3);
            } else {
                prize = (int) (this.prizePool * 0.2);
            }

            sb.append(String.format("%d. %s %s %dPP - $%d%n", i + 1,
                    car.getBrand(), car.getModel(), car.getPerformancePoints(), prize));
        }

        return sb.toString().trim();
    }

}
