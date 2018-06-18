package firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Team team = new Team("Levski");

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split(" ");
            team.addPlayer(new Person(lineArgs[0], lineArgs[1],
                    Integer.valueOf(lineArgs[2]), Double.valueOf(lineArgs[3])));
        }

        System.out.println(team.toString());
    }
}
