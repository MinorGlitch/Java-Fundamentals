package warningLevel;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Importance verbocityLevel;
    private List<Message> messages;

    public Logger(String verbocityLevel) {
        this.verbocityLevel = Enum.valueOf(Importance.class, verbocityLevel.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void addMessage(String importance, String message) {
        Message msg = new Message(importance, message);

        if (msg.getImportance().compareTo(verbocityLevel) >= 0) {
            this.messages.add(msg);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
