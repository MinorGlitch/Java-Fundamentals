package militaryElite.mission;

public class Mission implements IMission {
    private String codeName;
    private String state;

    private static final String IN_PROGRESS = "inProgress";
    private static final String FINISHED = "Finished";

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (!state.equals(IN_PROGRESS) && !state.equals(FINISHED)) {
            throw new IllegalArgumentException("");
        }

        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
