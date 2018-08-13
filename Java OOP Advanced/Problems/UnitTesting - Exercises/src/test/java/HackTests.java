import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HackTests {
    private static final double ABS = 12;

    @Test
    public void testAbs() {
        Assert.assertEquals("Absolute value not correct", ABS, Math.abs(-12), 0.0);
    }

    @Test
    public void testSeparator() {
        Assert.assertEquals("Doesn't end with \\n", "\r\n", System.lineSeparator());
    }

    @Test
    public void testFloor() {
        Assert.assertEquals("Not floored", 3, Math.floor(3.49), 0.0);
    }
}
