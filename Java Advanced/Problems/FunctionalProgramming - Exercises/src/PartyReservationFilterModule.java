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
                        while (filteredIterator.hasNext()) {
                            String name = filteredIterator.next();
                            if (startsWith.test(name, key)) {
                                allNames.add(name);
                                filteredIterator.remove();
                            }
                        }
                        break;
                    }

                    while (namesIterator.hasNext()) {
                        String name = namesIterator.next();
                        if (startsWith.test(name, key)) {
                            filteredNames.add(name);
                            namesIterator.remove();
                        }
                    }
                    break;
                }
                case "Ends with": {
                    String key = params[2];

                    if (filterType.equals("Remove filter")) {
                        while (filteredIterator.hasNext()) {
                            String name = filteredIterator.next();
                            if (endsWith.test(name, key)) {
                                allNames.add(name);
                                filteredIterator.remove();
                            }
                        }
                        break;
                    }

                    while (namesIterator.hasNext()) {
                        String name = namesIterator.next();
                        if (endsWith.test(name, key)) {
                            filteredNames.add(name);
                            namesIterator.remove();
                        }
                    }
                    break;
                }
                case "Contains": {
                    String key = params[2];

                    if (filterType.equals("Remove filter")) {
                        while (filteredIterator.hasNext()) {
                            String name = filteredIterator.next();
                            if (containsKey.test(name, key)) {
                                allNames.add(name);
                                filteredIterator.remove();
                            }
                        }
                        break;
                    }

                    while (namesIterator.hasNext()) {
                        String name = namesIterator.next();
                        if (containsKey.test(name, key)) {
                            filteredNames.add(name);
                            namesIterator.remove();
                        }
                    }
                    break;
                }
                default:
                    int length = Integer.valueOf(params[2]);

                    if (filterType.equals("Remove filter")) {
                        while (filteredIterator.hasNext()) {
                            String name = filteredIterator.next();
                            if (isSameLength.test(name, length)) {
                                allNames.add(name);
                                filteredIterator.remove();
                            }
                        }
                        break;
                    }

                    while (namesIterator.hasNext()) {
                        String name = namesIterator.next();
                        if (isSameLength.test(name, length)) {
                            filteredNames.add(name);
                            namesIterator.remove();
                        }
                    }
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
}
