package strategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int comparedByNameLength = o1.getName().length() - o2.getName().length();

        if (comparedByNameLength == 0) {
            return o1.getName().toUpperCase().charAt(0) - o2.getName().toUpperCase().charAt(0);
        }

        return comparedByNameLength;
    }
}
