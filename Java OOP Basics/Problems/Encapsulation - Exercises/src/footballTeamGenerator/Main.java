package footballTeamGenerator;

import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Team> teams = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] playerArgs = line.split(";");

            String command = playerArgs[0];
            String teamName;
            String playerName;
            Deque<Integer> stats;

            switch (command) {
                case "Team":
                    teamName = playerArgs[1];
                    createTeam(teamName, teams);
                    break;
                case "Add":
                    teamName = playerArgs[1];
                    playerName = playerArgs[2];
                    stats = getPlayerStats(playerArgs);
                    Player player;
                    try {
                       player  = new Player(playerName, stats.pop(), stats.pop(),
                                stats.pop(), stats.pop(), stats.pop());
                    }catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                    addPlayerToTeam(player, teamName);
                    break;
                case "Remove":
                    teamName = playerArgs[1];
                    playerName = playerArgs[2];
                    try {
                        removePlayer(teamName, playerName);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                    break;
                case "Rating":
                    teamName = playerArgs[1];
                    try {
                        printTeamRating(teamName);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                    break;
            }

            line = reader.readLine();
        }
    }

    private static void printTeamRating(String teamName) {
        if (!isTeamPresent(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist", teamName));
        }

        Team team = teams.get(teamName);

        System.out.printf("%s - %d%n", teamName, team.getRating());
    }

    private static void removePlayer(String teamName, String playerName) {
        if (!isTeamPresent(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist", teamName));
        }
        teams.get(teamName).removePlayer(playerName);
    }

    private static void addPlayerToTeam(Player player, String teamName) {
        Team team;

        if (isTeamPresent(teamName)) {
            team = teams.get(teamName);
            team.addPlayer(player);
        } else {
            throw new IllegalArgumentException(String.format("Team %s does not exist", teamName));
        }
    }

    private static boolean isTeamPresent(String teamName) {
        return teams.get(teamName) != null;
    }

    private static void createTeam(String teamName, Map<String, Team> teams) {
        teams.put(teamName, new Team(teamName));
    }

    private static Deque<Integer> getPlayerStats(String[] playerArgs) {
        return Arrays.asList(playerArgs).subList(3, playerArgs.length)
                .stream().map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    }

}
