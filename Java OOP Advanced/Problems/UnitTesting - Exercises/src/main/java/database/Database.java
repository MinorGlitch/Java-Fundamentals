package database;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;

public class Database {
    private Integer[] integers;

    public Database() {
        this.integers = new Integer[16];
    }

    public Database(Integer... numbers) {
        this();
        for (int i = 0; i < numbers.length; i++) {
            this.integers[i] = numbers[i];
        }
    }

    public void add(Integer number) throws OperationNotSupportedException {
        if (number == null){
            throw new OperationNotSupportedException();
        }

        for (int i = 0; i < this.integers.length; i++) {
            if (this.integers[i] == null) {
                this.integers[i] = number;
                return;
            }
        }

        throw new OperationNotSupportedException();
    }

    public void remove() throws OperationNotSupportedException {
        for (int i = this.integers.length - 1; i >= 0; i--) {
            if (this.integers[i] != null) {
                this.integers[i] = null;
                return;
            }
        }

        throw new OperationNotSupportedException();
    }

    public Integer[] fetch() {
        return this.integers;
    }
}
