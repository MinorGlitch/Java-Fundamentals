import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split(" "));

        int minimumPopulation = Integer.valueOf(reader.readLine());

        Supplier<Map<String, List<Integer>>> parseInput = () -> {
            Map<String, List<Integer>> map = new HashMap<>();

            for (String token : tokens) {
                String[] set = token.split(":");

                map.putIfAbsent(set[0], new ArrayList<>());
                map.get(set[0]).add(Integer.valueOf(set[1]));
            }
            return map;
        };

        Map<String, List<Integer>> districts = parseInput.get();

        Predicate<Map.Entry<String, List<Integer>>> filterPredicate = x -> {
            return x.getValue().stream().mapToInt(Integer::valueOf).sum() >= minimumPopulation;
        };

        Comparator<Map.Entry<String, List<Integer>>> sortByPopulation = (x, y) -> {
            return Integer.compare(y.getValue().stream().mapToInt(Integer::valueOf).sum(),
                    x.getValue().stream().mapToInt(Integer::valueOf).sum());
        };

        districts.entrySet().stream().filter(filterPredicate)
                .sorted(sortByPopulation)
                .forEach(x -> {
                    System.out.print(x.getKey() + ": ");
                    x.getValue().stream()
                            .sorted((x1, y1) -> y1.compareTo(x1))
                            .limit(5)
                            .forEach(s -> System.out.print(s + " "));
                    System.out.println();
                });
    }
}
