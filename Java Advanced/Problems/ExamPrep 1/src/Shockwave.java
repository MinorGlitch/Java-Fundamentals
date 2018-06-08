import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimension = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] room = new int[dimension[0]][dimension[1]];

        String line = reader.readLine();

        while (!"Here We Go".equals(line)) {
            int[] coordinates = Stream.of(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int x1 = coordinates[0];
            int y1 = coordinates[1];
            int x2 = coordinates[2];
            int y2 = coordinates[3];

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    room[i][j]++;
                }
            }

            line = reader.readLine();
        }

        printMatrix(room);

    }

    private static void printMatrix(int[][] room) {
        for (int[] row : room) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
