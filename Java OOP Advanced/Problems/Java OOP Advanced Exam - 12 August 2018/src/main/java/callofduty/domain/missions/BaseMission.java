package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class BaseMission implements Mission {
    private String id;
    private Double rating;
    private Double bounty;
    private String status;

    protected BaseMission(String id, Double rating, Double bounty) {
        this.setId(id);
        this.setRating(rating);
        this.setBounty(bounty);
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s Mission - %s\n" +
                        "Status: %s\n" +
                        "Rating: %.2f\n" +
                        "Bounty: %.2f\n",
                this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().indexOf("Mission")),
                this.getId(),
                this.status,
                this.getRating(),
                this.getBounty());
    }

    protected void setRating(Double rating) {
        this.rating = rating;
    }

    protected void setBounty(Double bounty) {
        this.bounty = bounty;
    }
}
