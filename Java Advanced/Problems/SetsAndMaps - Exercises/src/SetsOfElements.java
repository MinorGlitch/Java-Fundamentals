import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();

        for (int i = 0; i < n + m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            
            if (i < n) {
                nSet.add(number);
            } else {
                mSet.add(number);
            }
        }

        Set<Integer> matches = new LinkedHashSet<>();

        for (Integer number : nSet) {
            if (mSet.contains(number)) {
                matches.add(number);
            }
        }

        matches.forEach(num -> System.out.printf("%d ", num));
    }
}
