package warningLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Logger logger = new Logger(reader.readLine());

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] lineArgs = line.split(": ");

            logger.addMessage(lineArgs[0], lineArgs[1]);

            line = reader.readLine();
        }

        var messages = logger.getMessages();

        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
