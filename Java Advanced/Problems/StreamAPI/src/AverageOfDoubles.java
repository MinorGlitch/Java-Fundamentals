import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");

        OptionalDouble average = Arrays.stream(values).filter(x -> !x.isEmpty())
                .mapToDouble(Double::parseDouble).average();

        if (average.isPresent()) {
            System.out.printf("%1$.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
