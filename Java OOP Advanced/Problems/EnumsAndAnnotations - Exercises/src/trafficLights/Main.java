package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<TrafficLight> signals = Arrays.stream(reader.readLine().split(" "))
                .map(TrafficLight::valueOf).collect(Collectors.toList());

        int rows = Integer.valueOf(reader.readLine());

        TrafficState state = new TrafficState();

        for (int i = 0; i < rows; i++) {
            state.newState(signals);
            String[] res = signals.stream().map(Enum::toString).toArray(String[]::new);
            System.out.println(String.join(" ", res));
        }
    }
}
