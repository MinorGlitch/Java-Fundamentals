import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        String[][] matrix = new String[n][n];

        Deque<String> commands = new ArrayDeque<>();

        String[] commandsLine = reader.readLine().split(", ");

        for (String command : commandsLine) {
            commands.addLast(command);
        }

        int startX = 0;
        int startY = 0;
        long length = 1;

        long totalFood = 0;

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("s")) {
                    startX = i;
                    startY = j;
                }
                if (line[j].equals("f")) {
                    totalFood++;
                }
                matrix[i][j] = line[j];
            }
        }

        long eaten = 0;

        while (true) {
            if (commands.isEmpty() && totalFood != 0) {
                System.out.printf("You lose! There is still %d food to be eaten.", totalFood);
                return;
            } else if (commands.isEmpty() && totalFood == 0) {
                System.out.printf("You win! Final snake length is %d", length);
                return;
            }

            if (totalFood == 0) {
                System.out.printf("You win! Final snake length is %d", length);
                return;
            }
            String command = commands.pop();

            switch (command) {
                case "left":
                    startY--;
                    if (startY < 0) {
                        startY = n - 1;
                    }
                    if (isTreat(matrix, startX, startY)) {
                        eaten++;
                        totalFood--;
                        length++;
                    } else if (isEnemy(matrix, startX, startY)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "right":
                    startY++;
                    if (startY >= n) {
                        startY = 0;
                    }
                    if (isTreat(matrix, startX, startY)) {
                        eaten++;
                        length++;
                        totalFood--;
                    } else if (isEnemy(matrix, startX, startY)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "up":
                    startX--;
                    if (startX < 0) {
                        startX = n - 1;
                    }
                    if (isTreat(matrix, startX, startY)) {
                        eaten++;
                        totalFood--;
                        length++;
                    } else if (isEnemy(matrix, startX, startY)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "down":
                    startX++;
                    if (startX >= n) {
                        startX = 0;
                    }
                    if (isTreat(matrix, startX, startY)) {
                        eaten++;
                        totalFood--;
                        length++;
                    } else if (isEnemy(matrix, startX, startY)) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
            }
        }
    }

    private static boolean isTreat(String[][] matrix, int startX, int startY) {
        return matrix[startX][startY].equals("f");
    }

    private static boolean isEnemy(String[][] matrix, int startX, int startY) {
        return matrix[startX][startY].equals("e");
    }
}
