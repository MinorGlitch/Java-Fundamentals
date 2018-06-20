package footballTeamGenerator;

import java.util.*;

public class Team {
    private String name;
    private List<Player> players;

    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";
    private static final String MISSING_PLAYER_MESSAGE = "Player %s is not in %s team.";

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int getRating() {
        int average = 0;

        if (players.size() == 0) {
            return 0;
        }

        for (Player player : players) {
            average += player.getPlayerRating();
        }

        return Math.round(average / players.size());
    }

    public void removePlayer(String playerName) {
        if (!isPresent(playerName)) {
            throw new IllegalArgumentException(String.format(MISSING_PLAYER_MESSAGE, playerName, this.name));
        }

        players.remove(findPlayer(playerName).get());
    }

    private boolean isPresent(String playerName) {
        return findPlayer(playerName).isPresent();
    }

    private Optional<Player> findPlayer(String playerName) {
       return this.players.stream().filter(p -> p.getName().equals(playerName)).findFirst();
    }

    private void setName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    private boolean isValidName(String name) {
        return  name != null || !name.isEmpty();
    }
}
