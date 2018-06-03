import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String line = reader.readLine();

        BiPredicate<String, String> startsWith = (name, value) -> {
            int valueLength = value.length();
            return name.substring(0, valueLength).equals(value);
        };

        BiPredicate<String, String> endsWith = (name, value) -> {
            int valueLength = value.length();
            return name.substring(name.length() - valueLength, name.length()).equals(value);
        };

        BiPredicate<String, Integer> checkLength = (name, length) -> name.length() <= length;

        BiConsumer<String, String> doubleBy = (criteria, value) -> {
            Iterator<String> iterator = people.iterator();
            List<String> additionalGuests = new ArrayList<>();
            switch (criteria) {
                case "StartsWith":
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        if (startsWith.test(name, value)) {
                            additionalGuests.add(name);
                        }
                    }
                    break;
                case "EndsWith":
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        if (endsWith.test(name, value)) {
                            additionalGuests.add(name);
                        }
                    }
                    break;
                case "Length":
                    int length = Integer.valueOf(value);
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        if (checkLength.test(name, length)) {
                            additionalGuests.add(name);
                        }
                    }
                    break;
            }

            people.addAll(additionalGuests);
        };

        BiConsumer<String, String> removeBy = (criteria, value) -> {
            Iterator<String> iterator = people.iterator();
            switch (criteria) {
                case "StartsWith":
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        if (startsWith.test(name, value)) {
                            iterator.remove();
                        }
                    }
                    break;
                case "EndsWith":
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        if (endsWith.test(name, value)) {
                            iterator.remove();
                        }
                    }
                    break;
                case "Length":
                    int length = Integer.valueOf(value);
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        if (checkLength.test(name, length)) {
                            iterator.remove();
                        }
                    }
                    break;
            }
        };

        while (!line.equals("Party!")) {
            String[] lineArgs = line.split("\\s+");

            switch (lineArgs[0]) {
                case "Double":
                    doubleBy.accept(lineArgs[1], lineArgs[2]);
                    break;
                case "Remove":
                    removeBy.accept(lineArgs[1], lineArgs[2]);
                    break;
            }

            line = reader.readLine();
        }

        String output = String.join(", ", people) + " are";

        if (people.size() == 0) {
            output = "Nobody is";
        }

        System.out.printf("%1$s going to the party!", output);
    }
}
