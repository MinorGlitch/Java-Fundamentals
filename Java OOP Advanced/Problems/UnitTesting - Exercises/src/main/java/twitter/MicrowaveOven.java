package twitter;

public class MicrowaveOven implements Client {
    private String message;

    @Override
    public void receiveMessage(Tweet message) {
        this.message = message.retrieveMessage();

        System.out.println(this.message);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
