package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public RandomArrayList() {
        random = new Random();
    }

    public Object getRandomElement() {
        int randomIndex = random.nextInt(super.size() - 1);

        Object obj = super.get(randomIndex);
        super.remove(obj);

        return obj;
    }
}
