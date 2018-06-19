package footballTeamGenerator;

import javafx.css.Match;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    private static final int STAT_MIN_VALUE = 0;
    private static final int STAT_MAX_VALUE = 100;

    private static final String INVALID_STAT_MESSAGE = "%s should be between 0 and 100.";
    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setEndurance(int endurance) {
        if (!isValidStat(endurance)) {
            throw new IllegalArgumentException(String.format(INVALID_STAT_MESSAGE, "Endurance"));
        }
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }

    public double getPlayerRating() {
        return Math.round((sprint + dribble + passing + shooting + endurance) / 5.0);
    }

    private void setName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    private void setSprint(int sprint) {
        if (!isValidStat(sprint)) {
            throw new IllegalArgumentException(String.format(INVALID_STAT_MESSAGE, "Sprint"));
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (!isValidStat(dribble)) {
            throw new IllegalArgumentException(String.format(INVALID_STAT_MESSAGE, "Dribble"));
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (!isValidStat(passing)) {
            throw new IllegalArgumentException(String.format(INVALID_STAT_MESSAGE, "Passing"));
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (!isValidStat(shooting)) {
            throw new IllegalArgumentException(String.format(INVALID_STAT_MESSAGE, "Shooting"));
        }
        this.shooting = shooting;
    }

    private boolean isValidStat(int stat) {
        return (stat > STAT_MIN_VALUE && stat <= STAT_MAX_VALUE);
    }

    private boolean isValidName(String name) {
        return !name.isEmpty();
    }
}
