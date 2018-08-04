package logger;

import logger.interfaces.Appender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Controller controller = new Controller();

        List<Appender> appenders = new ArrayList<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            try {
                appenders.add(controller.parseAppender(reader.readLine().split(" ")));
            } catch (Exception ignored) {

            }
        }

        controller.createRepository(appenders);

        String line = reader.readLine();

        while (!"END".equals(line)) {
            controller.readCommand(line);

            line = reader.readLine();
        }

        System.out.println("Logger info");
        controller.getRepository().getLogger().getAppenders().forEach(System.out::println);
    }
}
