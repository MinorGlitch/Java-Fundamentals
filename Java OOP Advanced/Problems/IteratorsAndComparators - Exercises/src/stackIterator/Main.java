package stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        StackIterator<Integer> stackIterator = new StackIterator<>();

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] lineArgs = line.split(", | ");

            switch (lineArgs[0]) {
                case "Push":
                    Integer[] vals = Arrays.stream(lineArgs).skip(1).map(Integer::valueOf).toArray(Integer[]::new);
                    stackIterator.push(vals);
                    break;
                case "Pop":
                    stackIterator.pop();
                    break;
            }

            line = reader.readLine();
        }

        for (int i = 0; i < 2; i++) {
            for (Integer integer : stackIterator) {
                System.out.println(integer);
            }
        }
    }
}
