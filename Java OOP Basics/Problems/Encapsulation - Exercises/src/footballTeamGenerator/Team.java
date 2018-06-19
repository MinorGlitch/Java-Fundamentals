package footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Player> players;
    private int rating;

    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";
    private static final String MISSING_PLAYER_MESSAGE = "Player %s is not in %s team.";

    public Team(String name) {
        this.setName(name);
        this.players = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        this.players.putIfAbsent(player.getName(), player);
    }

    public int getRating() {
        if (players.size() == 0) {
            return 0;
        }
        return (int) players.values().stream().mapToDouble(Player::getPlayerRating).average().getAsDouble();
    }

    public boolean containsPlayer(String name) {
        return this.players.containsKey(name);
    }

    public void removePlayer(String playerName) {
        if (!isPresent(playerName)) {
            throw new IllegalArgumentException(String.format(MISSING_PLAYER_MESSAGE, playerName, this.name));
        }

        players.remove(playerName);
    }

    private boolean isPresent(String playerName) {
        return this.players.get(playerName) != null;
    }

    private void setName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    private boolean isValidName(String name) {
        return !name.isEmpty();
    }
}
