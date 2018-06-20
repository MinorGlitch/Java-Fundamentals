package footballTeamGenerator;

import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Team> teams = new LinkedHashMap<>();


    //TODO: NEEDS REFACTORING!!!
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] playerArgs = line.split(";");

            String command = playerArgs[0];
            String teamName = playerArgs[1];
            String playerName;
            Deque<Integer> stats;

            switch (command) {
                case "Team":
                    try {
                        createTeam(teamName, teams);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    playerName = playerArgs[2];
                    stats = getPlayerStats(playerArgs);
                    try {
                        addPlayerToTeam(teamName, playerName, stats);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Remove":
                    playerName = playerArgs[2];
                    try {
                        removePlayer(teamName, playerName);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    try {
                        printTeamRating(teamName);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            line = reader.readLine();
        }
    }

    private static void printTeamRating(String teamName) {
        if (!isTeamPresent(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }

        Team team = teams.get(teamName);

        System.out.printf("%s - %d%n", teamName, team.getRating());
    }

    private static void removePlayer(String teamName, String playerName) {
        if (!isTeamPresent(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }

        teams.get(teamName).removePlayer(playerName);
    }

    private static void addPlayerToTeam(String teamName, String playerName, Deque<Integer> stats) {
        if (isTeamPresent(teamName)) {
            teams.get(teamName).addPlayer(new Player(playerName, stats.pop(), stats.pop(),
                    stats.pop(), stats.pop(), stats.pop()));
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }

    private static boolean isTeamPresent(String teamName) {
        return teams.containsKey(teamName);
    }

    private static void createTeam(String teamName, Map<String, Team> teams) {
        teams.putIfAbsent(teamName, new Team(teamName));
    }

    private static Deque<Integer> getPlayerStats(String[] playerArgs) {
        return Arrays.asList(playerArgs).subList(3, playerArgs.length)
                .stream().map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    }

}
