package twitter;

public class Message implements Tweet {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String retrieveMessage() {
        return this.message;
    }
}
