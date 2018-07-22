package infernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        WeaponRepository repository = new WeaponRepository();

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] commandArgs = line.split(";");
            CommandDispatcher.dispatchCommand(commandArgs, repository);

            line = reader.readLine();
        }
    }
}
