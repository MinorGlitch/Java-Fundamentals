package catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            String[] catArgs = line.split(" ");

            String type = catArgs[0];

            String name = catArgs[1];

            createCat(type, name, cats, catArgs);

            line = reader.readLine();
        }

        String cat = reader.readLine();

        System.out.println(cats.get(cat).toString());
    }

    private static void createCat(String type, String name, Map<String, Cat> cats, String[] catArgs) {
        switch (type) {
            case "Cymric":
                double furLength = Double.valueOf(catArgs[2]);
                cats.putIfAbsent(name, new CymricCat(furLength, name));
                break;
            case "Siamese":
                double earSize = Double.valueOf(catArgs[2]);
                cats.putIfAbsent(name, new SiameseCat(earSize, name));
                break;
            default:
                double meowDecibels = Double.valueOf(catArgs[2]);
                cats.putIfAbsent(name, new StreetCat(meowDecibels, name));
                break;
        }
    }
}
