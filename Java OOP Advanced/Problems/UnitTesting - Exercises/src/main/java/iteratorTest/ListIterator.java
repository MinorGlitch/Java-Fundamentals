package iteratorTest;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIterator {
    private List<String> strings;
    private int index;

    public ListIterator(List<String> strings) throws OperationNotSupportedException {
        if (strings.contains(null)) {
            throw new OperationNotSupportedException();
        }

        this.strings = new ArrayList<>(strings);
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }

        return false;
    }

    public void print() throws OperationNotSupportedException {
        if (this.strings.isEmpty()) {
            throw new OperationNotSupportedException("Invalid operation!");
        }
        System.out.println(this.strings.get(this.index));
    }

    public boolean hasNext() {
        return index + 1 < this.strings.size();
    }
}
