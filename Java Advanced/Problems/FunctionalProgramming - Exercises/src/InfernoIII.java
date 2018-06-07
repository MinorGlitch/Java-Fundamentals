import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfernoIII {

    private static Set<Integer> indexesToRemove = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> gems = Stream.of(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> excluded = new ArrayList<>();

        String line = reader.readLine();

        BiConsumer<String, Pair<String, Integer>> sum = (type, pair) -> {

            if (type.equals("Sum Left")) {
                sumLeft(gems, pair.getValue(), excluded, pair.getKey());
            } else if (type.equals("Sum Left Right")) {
                sumLeftRight(gems, pair.getValue(), excluded, pair.getKey());
            } else {
                sumRight(gems, pair.getValue(), excluded, pair.getKey());

            }
        };

        while (!line.equals("Forge")) {
            String[] tokens = line.split(";");

            int targetGem = Integer.valueOf(tokens[2]);
            sum.accept(tokens[1], new Pair<>(tokens[0], targetGem));

            line = reader.readLine();
        }

        excluded.sort((o1, o2) -> o2.compareTo(o1));

        for (int excludedGem : excluded.stream().distinct().collect(Collectors.toList())) {
            if (!gems.isEmpty()) {
                gems.remove(excludedGem);
            }
        }

        gems.forEach(g -> System.out.print(g + " "));
    }

    private static void sumRight(List<Integer> gems, Integer gem, List<Integer> excluded, String type) {
        int sum = 0;
        for (int i = 0; i < gems.size(); i++) {
            sum += gems.get(i);

            try {
                sum += gems.get(i + 1);
            } catch (IndexOutOfBoundsException ex) {
                sum += 0;
            }

            if (sum == gem) {
                if (type.equals("Reverse")) {
                    if (!excluded.isEmpty()) {
                        excluded.remove(i);
                    }
                }
                excluded.add(i);
            }
            sum = 0;

        }

    }

    private static void sumLeftRight(List<Integer> gems, Integer gem, List<Integer> excluded, String type) {
        int sum = 0;
        for (int i = 0; i < gems.size(); i++) {
            sum += gems.get(i);
            try {
                sum += gems.get(i - 1);
            } catch (IndexOutOfBoundsException ex) {
                sum += 0;
            }

            try {
                sum += gems.get(i + 1);
            } catch (IndexOutOfBoundsException ex) {
                sum += 0;
            }

            if (sum == gem) {
                if (type.equals("Reverse")) {
                    if (!excluded.isEmpty()) {
                        excluded.remove(i);
                    }
                }
                excluded.add(i);
            }
            sum = 0;

        }

    }

    private static void sumLeft(List<Integer> gems, int gem, List<Integer> excluded, String type) {
        int sum = 0;
        for (int i = 0; i < gems.size(); i++) {
            sum += gems.get(i);
            try {
                sum += gems.get(i - 1);
            } catch (IndexOutOfBoundsException ex) {
                sum += 0;
            }

            if (sum == gem) {
                if (type.equals("Reverse")) {
                    if (!excluded.isEmpty()) {
                        excluded.remove(i);
                    }
                    continue;
                }
                excluded.add(i);
            }
            sum = 0;
        }
    }
}
