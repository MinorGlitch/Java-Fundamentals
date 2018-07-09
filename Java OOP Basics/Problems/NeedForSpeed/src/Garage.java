import cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return this.parkedCars;
    }

    public boolean containsCar(Car car) {
        return parkedCars.contains(car);
    }
}
