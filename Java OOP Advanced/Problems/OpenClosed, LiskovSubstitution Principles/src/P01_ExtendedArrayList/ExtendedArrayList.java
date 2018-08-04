package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {
    public T min() {
        T minElement = null;

        Iterator<T> iterator = super.iterator();

        if (iterator.hasNext()) {
            minElement = iterator.next();
        }

        while (iterator.hasNext()) {
            T current = iterator.next();
            if (minElement.compareTo(current) >= 0) {
                minElement = current;
            }
        }

        return minElement;
    }

    public T max() {
        T minElement = null;

        Iterator<T> iterator = super.iterator();

        if (iterator.hasNext()) {
            minElement = iterator.next();
        }

        while (iterator.hasNext()) {
            T current = iterator.next();
            if (minElement.compareTo(current) <= 0) {
                minElement = current;
            }
        }

        return minElement;
    }
}
