import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> history = new ArrayDeque<>();

        String text = "";

        boolean canRemove = false;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            String command = line[0];

            switch (command) {
                case "1":
                    String currentText = line[1];
                    history.push(text);
                    text += currentText;
                    break;
                case "2":
                    history.push(text);
                    int count = Integer.parseInt(line[1]);
                    int start = text.length() - count;
                    text = text.substring(0, start);
                    break;
                case "3":
                    int index = Integer.parseInt(line[1]) - 1;

                    if (index == -1) {
                        index = 0;
                    }

                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    text = history.pop();
                    break;
            }
        }
    }
}
