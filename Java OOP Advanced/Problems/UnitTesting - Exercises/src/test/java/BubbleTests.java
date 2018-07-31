import bubbleSort.Bubble;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BubbleTests {
    private static final List<Integer> NUMBERS = new ArrayList<>() {{
        add(15);
        add(-21);
        add(-12);
        add(90);
        add(0);
    }};

    private static final List<Integer> SORTED = new ArrayList<>() {{
        add(-21);
        add(-12);
        add(-0);
        add(15);
        add(90);
    }};

    private Bubble bubble;

    @Before
    public void setBubble() {
        this.bubble = new Bubble();
    }

    @Test
    public void bubbleSort() {
        this.bubble.sort(NUMBERS);

        Assert.assertEquals("Not sorted", NUMBERS, SORTED);
    }
}
