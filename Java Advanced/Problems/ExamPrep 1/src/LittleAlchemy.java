import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stones = Stream.of(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int gold = 0;

        String line = reader.readLine();

        while (!"Revision".equals(line)) {

            String[] tokens = line.split(" ");

            int applications = Integer.valueOf(tokens[2]);

            switch (tokens[0]) {
                case "Apply":
                    gold = applyAcid(stones, applications, gold);
                    break;
                case "Air":
                    gold = airLeak(stones, applications, gold);
                    break;
            }

            line = reader.readLine();
        }

        stones.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println(gold);
    }

    private static int airLeak(Deque<Integer> stones, int stoneValue, int gold) {
        if (gold == 0) {
            return gold;
        }

        stones.addLast(stoneValue);

        return --gold;
    }

    private static int applyAcid(Deque<Integer> stones, int applications, int gold) {
        if (stones.isEmpty()) {
            return gold;
        }

        for (int i = 0; i < applications; i++) {
            if (!stones.isEmpty()) {
                int stone = stones.pop();
                stone--;

                if (stone == 0) {
                    gold++;
                    continue;
                }

                stones.addLast(stone);
            }
        }

        return gold;
    }
}
