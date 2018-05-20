import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> children = new ArrayDeque<>();

        Collections.addAll(children, scanner.nextLine().split(" "));

        int toss = Integer.parseInt(scanner.nextLine());

        int cycle = 1;

        while (children.size() != 1) {

            for (int i = 1; i < toss; i++) {
                children.offer(children.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + children.peekFirst());
            } else {
                System.out.println("Removed " + children.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + children.pop());
    }

    static boolean isPrime(int number) {

        if (number == 0 || number == 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
