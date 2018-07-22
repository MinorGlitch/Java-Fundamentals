package trafficLights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrafficState {

    public TrafficState() {

    }

    public void newState(List<TrafficLight> lights) {
        for (int i = 0; i < lights.size(); i++) {
            TrafficLight[] signals = TrafficLight.values();
            int current = lights.get(i).ordinal();
            TrafficLight newLight = signals[(current + 1) % signals.length];
            lights.set(i, newLight);
        }
    }
}
