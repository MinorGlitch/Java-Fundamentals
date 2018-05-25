import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    private static Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();

        while (!line.equals("report")) {
            String[] lineArgs = line.split("\\|");

            String city = lineArgs[0];
            String country = lineArgs[1];
            long population = Long.parseLong(lineArgs[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).putIfAbsent(city, 0L);

            countries.get(country).put(city, countries.get(country).get(city) + population);

            line = scanner.nextLine();
        }

        countries = countries.entrySet().stream().sorted((country1, country2) -> {
            long firstPopulation = country1.getValue().values().stream().mapToLong(Long::valueOf).sum();
            long secondPopulation = country2.getValue().values().stream().mapToLong(Long::valueOf).sum();

            return Long.compare(secondPopulation, firstPopulation);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> country : countries.entrySet()) {
            long totalPopulation = country.getValue().values().stream().mapToLong(Long::valueOf).sum();

            System.out.printf("%s (total population: %d)%n", country.getKey(), totalPopulation);

            Map<String, Long> sortedCities = country.getValue()
                    .entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            }
        }
    }
}
