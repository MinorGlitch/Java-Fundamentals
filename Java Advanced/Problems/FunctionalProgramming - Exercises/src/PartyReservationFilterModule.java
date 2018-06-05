import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class PartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> allNames = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        List<String> filteredNames = new ArrayList<>();

        BiPredicate<String, String> containsKey = String::contains;
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, Integer> isSameLength = (word, length) -> word.length() == length;

        Consumer<String[]> filterNames = params -> {
            Iterator<String> namesIterator = allNames.iterator();
            Iterator<String> filteredIterator = filteredNames.iterator();
            String filterType = params[0];

            switch (params[1]) {
                case "Starts with": {
                    String key = params[2];

                    if (filterType.equals("Remove filter")) {
                        removeFilter(allNames, startsWith, filteredIterator, key);

                        break;
                    }
                    addFilter(filteredNames, startsWith, namesIterator, key);
                    break;
                }
                case "Ends with": {
                    String key = params[2];

                    if (filterType.equals("Remove filter")) {
                        removeFilter(allNames, endsWith, filteredIterator, key);
                        break;
                    }
                    addFilter(filteredNames, endsWith, namesIterator, key);
                    break;
                }
                case "Contains": {
                    String key = params[2];

                    if (filterType.equals("Remove filter")) {
                        removeFilter(allNames, containsKey, filteredIterator, key);
                        break;
                    }

                    addFilter(filteredNames, containsKey, namesIterator, key);
                    break;
                }
                default:
                    int length = Integer.valueOf(params[2]);

                    if (filterType.equals("Remove filter")) {
                        removeFilter(allNames, isSameLength, filteredIterator, length);
                        break;
                    }
                    addFilter(filteredNames, isSameLength, namesIterator, length);
                    break;
            }
        };

        String line = reader.readLine();

        while (!line.equals("Print")) {
            filterNames.accept(line.split(";"));
            line = reader.readLine();
        }

        allNames.forEach(name -> System.out.print(name + " "));
    }

    private static void addFilter(List<String> filtered
            , BiPredicate<String, String> predicate, Iterator<String> namesIterator, String key) {

        while (namesIterator.hasNext()) {
            String name = namesIterator.next();
            boolean val = predicate.test(name, key);
            if (val) {
                filtered.add(name);
                namesIterator.remove();
            }
        }
    }

    private static void addFilter(List<String> filtered
            , BiPredicate<String, Integer> predicate, Iterator<String> namesIterator, int key) {

        while (namesIterator.hasNext()) {
            String name = namesIterator.next();
            boolean val = predicate.test(name, key);
            if (val) {
                filtered.add(name);
                namesIterator.remove();
            }
        }
    }

    private static void removeFilter(List<String> allNames
            , BiPredicate<String, Integer> predicate, Iterator<String> filteredIterator, int key) {

        while (filteredIterator.hasNext()) {
            String name = filteredIterator.next();
            boolean val = predicate.test(name, key);
            if (val) {
                allNames.add(name);
                filteredIterator.remove();
            }
        }
    }

    private static void removeFilter(List<String> allNames
            , BiPredicate<String, String> predicate, Iterator<String> filteredIterator, String key) {

        while (filteredIterator.hasNext()) {
            String name = filteredIterator.next();
            boolean val = predicate.test(name, key);
            if (val) {
                allNames.add(name);
                filteredIterator.remove();
            }
        }
    }
}
