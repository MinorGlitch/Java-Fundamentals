package databaseTests;

import database.DatabaseExtended;
import database.Person;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedTests {
    private static final Person[] people = new Person[] {
            new Person(1, "aa"),
            new Person(2, "bb"),
            new Person(3, "cc"),
            new Person(4, "dd"),
            new Person(5, "ee"),
            new Person(6, "ff"),
            new Person(7, "gg"),
            new Person(8, "hh"),
            new Person(9, "ii"),
            new Person(10, "kk"),
            new Person(11, "ll")
    };

    @Test(expected = OperationNotSupportedException.class)
    public void addDuplicatePersonId() throws OperationNotSupportedException {
        DatabaseExtended databaseExtended = new DatabaseExtended(people);

        databaseExtended.add(new Person(1, "aa"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNegativePersonId() throws OperationNotSupportedException {
        DatabaseExtended databaseExtended = new DatabaseExtended(people);

        databaseExtended.add(new Person(-1, "aa"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDB() throws OperationNotSupportedException {
        DatabaseExtended databaseExtended = new DatabaseExtended();

        databaseExtended.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findNonExistentId() throws OperationNotSupportedException {
        DatabaseExtended databaseExtended = new DatabaseExtended(people);

        var res = databaseExtended.findById(75);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByNonExistentUsername() throws OperationNotSupportedException {
        DatabaseExtended databaseExtended = new DatabaseExtended(people);

        var res = databaseExtended.findByUsername("dsgdagre");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByNullUsername() throws OperationNotSupportedException {
        DatabaseExtended databaseExtended = new DatabaseExtended(people);

        var nullRes = databaseExtended.findByUsername(null);
    }

    @Test
    public void createDb() {
        DatabaseExtended databaseExtended = new DatabaseExtended();

        Assert.assertNotNull(databaseExtended);
    }
}
