import iteratorTest.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

public class IteratorTests {
    private ListIterator listIterator;

    @Before
    public void createIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(new ArrayList<>());
    }

    @Test
    public void moveOutsideOfBoundaries() throws OperationNotSupportedException {
        boolean res = this.listIterator.move();

        Assert.assertFalse(res);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void printNonExistentString() throws OperationNotSupportedException {
        this.listIterator.print();
    }

    @Test
    public void doesntHaveNext() throws OperationNotSupportedException {
        Assert.assertFalse(this.listIterator.hasNext());
    }
}
