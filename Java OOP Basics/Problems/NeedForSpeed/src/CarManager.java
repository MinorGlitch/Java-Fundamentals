import cars.Car;
import cars.CarFactory;
import races.Race;
import races.RaceFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> allCars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.allCars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability) {

        Car newCar = CarFactory.createCar(type, brand, model, yearOfProduction, horsepower, acceleration,
                suspension, durability);

        allCars.put(id, newCar);
    }

    public String check(int id) {
        return allCars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = RaceFactory.createRace(type, length, route, prizePool);

        races.put(id, race);
    }

    public void participate(int carId, int raceId) {
        Race race = races.get(raceId);

        Car car = allCars.get(carId);

        if (!garage.containsCar(car)) {
            races.get(raceId).addParticipant(car);
        }
    }

    public String start(int raceId) {
        if (races.get(raceId).isEmpty()) {
            return "Cannot start the race with zero participants.";
        }

        races.get(raceId).calculatePerformance();

        String output = races.get(raceId).toString();

        races.remove(raceId);

        return output;
    }

    public void park(int id) {
        Car car = allCars.get(id);

        for (Race race : races.values()) {
            if (race.containsCar(car)) {
                return;
            }
        }

        this.garage.getParkedCars().add(car);
    }

    public void unpark(int id) {
        Car car = this.allCars.get(id);

        this.garage.getParkedCars().remove(car);
    }

    public void tune(int tuneIndex, String addOn) {
        if (garage.getParkedCars().size() == 0) {
            return;
        }


        for (Car car : garage.getParkedCars()) {
            car.tuneHorsepower(tuneIndex);
            car.tuneSuspension(tuneIndex);
            switch (car.getClass().getSimpleName()) {
                case "PerformanceCar":
                    car.tune(addOn);
                    break;
                default:
                    car.tune(String.valueOf(tuneIndex));
                    break;
            }
        }
    }
}
