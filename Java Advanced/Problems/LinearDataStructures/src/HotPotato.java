import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> children = new ArrayDeque<>();

        Collections.addAll(children, scanner.nextLine().split(" "));

        int toss = Integer.parseInt(scanner.nextLine());

        while (children.size() != 1) {
            for (int i = 1; i < toss; i++) {
                children.offer(children.poll());
            }

            System.out.println("Removed " + children.pop());
        }

        System.out.println("Last is " + children.pop());
    }
}
