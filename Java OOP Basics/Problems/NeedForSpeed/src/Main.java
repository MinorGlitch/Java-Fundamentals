import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        CarManager manager = new CarManager();

        while (!"Cops Are Here".equals(line)) {
            String[] autoArgs = line.split(" ");

            int id;
            String type;

            switch (autoArgs[0]) {
                case "register":
                    id = Integer.valueOf(autoArgs[1]);
                    type = autoArgs[2];
                    String brand = autoArgs[3];
                    String model = autoArgs[4];
                    int year = Integer.valueOf(autoArgs[5]);
                    int horsepower = Integer.valueOf(autoArgs[6]);
                    int acceleration = Integer.valueOf(autoArgs[7]);
                    int suspention = Integer.valueOf(autoArgs[8]);
                    int durability = Integer.valueOf(autoArgs[9]);
                    manager.register(id, type, brand, model, year, horsepower,
                            acceleration, suspention, durability);
                    break;
                case "check":
                    id = Integer.valueOf(autoArgs[1]);
                    System.out.println(manager.check(id));
                    break;
                case "open":
                    id = Integer.valueOf(autoArgs[1]);
                    type = autoArgs[2];
                    int length = Integer.valueOf(autoArgs[3]);
                    String route = autoArgs[4];
                    int prizePool = Integer.valueOf(autoArgs[5]);
                    manager.open(id, type, length, route, prizePool);
                    break;
                case "participate":
                    id = Integer.valueOf(autoArgs[1]);
                    int raceId = Integer.valueOf(autoArgs[2]);
                    manager.participate(id, raceId);
                    break;
                case "start":
                    id = Integer.valueOf(autoArgs[1]);
                    System.out.println(manager.start(id));
                    break;
                case "tune":
                    int tuneIndex = Integer.valueOf(autoArgs[1]);
                    String addOn = autoArgs[2];

                    manager.tune(tuneIndex, addOn);
                    break;
                case "park":
                    id = Integer.valueOf(autoArgs[1]);
                    manager.park(id);
                    break;
                case "unpark":
                    id = Integer.valueOf(autoArgs[1]);
                    manager.unpark(id);
                    break;
            }

            line = reader.readLine();
        }
    }
}
