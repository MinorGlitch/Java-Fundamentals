package twitter;

public interface Client {
    void receiveMessage(Tweet message);
    String getMessage();
}
