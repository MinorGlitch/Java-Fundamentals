package P05_Square;

import org.junit.Assert;
import org.junit.Test;

public class TetragonTests {
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void squareTest() {
        Tetragon square = new Square();

        square.setHeight(7);
        square.setWidth(3);

        Assert.assertEquals(9, square.getArea());
    }
}
