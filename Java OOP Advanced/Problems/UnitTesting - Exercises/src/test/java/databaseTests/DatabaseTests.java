package databaseTests;

import database.Database;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseTests {
    private static final int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    @Test
    public void validateDBCapacity() {
        Database database = new Database();

        Assert.assertEquals(16, database.fetch().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNull() throws OperationNotSupportedException {
        Database database = new Database();

        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addToFullDB() throws OperationNotSupportedException {
        Integer[] input = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Database database = new Database(input);

        database.add(12);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDB() throws OperationNotSupportedException {
        Database database = new Database();

        database.remove();
    }

    @Test
    public void createEmptyDB() {
        Database database = new Database();

        Assert.assertNotNull(database);
    }

    @Test
    public void fetchReturnsArray() {
        Database database = new Database();

        var result = database.fetch();

        Assert.assertNotNull(result);
    }

    @Test
    public void createDB() {
        Database database = new Database(1, 2, 3);

        var result = database.fetch();

        for (int i = 0; i < 3; i++) {
            Integer integer = result[i];

            Assert.assertNotNull(integer);
        }
    }
}
