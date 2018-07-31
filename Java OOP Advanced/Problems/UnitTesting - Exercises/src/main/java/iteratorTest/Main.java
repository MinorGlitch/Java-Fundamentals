package iteratorTest;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = Arrays.asList(
                Arrays.stream(reader.readLine().split(" ")).skip(1).toArray(String[]::new));

        ListIterator listIterator = new ListIterator(strings);

        String line = reader.readLine();

        while (!"END".equals(line)) {

            switch (line) {
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        listIterator.print();
                    } catch (OperationNotSupportedException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
            }

            line = reader.readLine();
        }
    }
}
