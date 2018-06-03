import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");

        Consumer<String[]> printStrings = strs -> {
            for (String str : strs) {
                System.out.println(str);
            }
        };

        printStrings.accept(strings);
    }
}
