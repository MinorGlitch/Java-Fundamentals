import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Pair<String, String>>> games = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([A-Za-z]+) - ([A-Za-z]+) result (\\d+:\\d+)");

        String line = reader.readLine();

        while (!"Season End".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String home = matcher.group(1);
                String away = matcher.group(2);
                String score = matcher.group(3);

                games.putIfAbsent(home, new ArrayList<>());
                games.putIfAbsent(away, new ArrayList<>());

                games.get(home).add(new Pair<>(away, score));
                games.get(away).add(new Pair<>(home, reverseScore(score)));
            }

            line = reader.readLine();
        }

        String[] teamsToPrint = reader.readLine().split(", ");

        printGames(games, teamsToPrint);
    }

    private static void printGames(Map<String, List<Pair<String, String>>> games, String[] teamsToPrint) {
        for (String team : teamsToPrint) {

            Map<String, List<Pair<String, String>>> teams = games.entrySet().stream().filter(s -> s.getKey().equals(team))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, List<Pair<String, String>>> teamEntry : teams.entrySet()) {

                List<Pair<String, String>> awayEntry = teamEntry.getValue()
                        .stream().sorted(Comparator.comparing(Pair::getKey))
                        .collect(Collectors.toCollection(ArrayList::new));

                for (Pair<String, String> away : awayEntry) {
                    System.out.printf("%s - %s -> %s%n", teamEntry.getKey(), away.getKey(), away.getValue());
                }
            }
        }
    }

    private static String reverseScore(String score) {
        return new StringBuilder(score).reverse().toString();
    }
}
