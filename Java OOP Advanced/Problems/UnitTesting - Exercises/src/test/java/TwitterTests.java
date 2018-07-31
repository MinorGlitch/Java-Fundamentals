import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import twitter.Client;
import twitter.Message;
import twitter.MicrowaveOven;
import twitter.Tweet;

public class TwitterTests {
    private Client client;
    private Tweet tweet;

    @Before
    public void initializeObjects() {
        this.client = new MicrowaveOven();
        this.tweet = new Message("Test tweet");
    }

    @Test
    public void isMessageCreated() {
        Assert.assertNotNull(this.tweet.retrieveMessage());
    }

    @Test
    public void ClientReceivedMessage() {
        this.client.receiveMessage(this.tweet);

        Assert.assertNotNull(this.client.getMessage());
    }
}
