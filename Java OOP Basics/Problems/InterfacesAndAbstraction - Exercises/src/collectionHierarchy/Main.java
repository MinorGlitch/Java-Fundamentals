package collectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static AddCollection addCollection = new AddCollectionImpl();
    private static AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImpl();
    private static MyList myList = new MyListImpl();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] items = reader.readLine().split(" ");

        fillAll(items, addCollection, addRemoveCollection, myList);

        int timesToRemove = Integer.valueOf(reader.readLine());

        removeAll(timesToRemove, myList, addRemoveCollection);

        System.out.println(sb.toString());

    }

    private static void removeAll(int timesToRemove, AddRemoveCollection... collections) {
        for (AddRemoveCollection collection : collections) {
            remove(timesToRemove, collection);
        }
    }

    private static void fillAll(String[] items, AddCollection... collections) {
        for (AddCollection collection : collections) {
            fill(collection, items);
        }
    }

    private static void fill(AddCollection collection, String... items) {
        for (String item : items) {
            sb.append(collection.add(item)).append(" ");
        }

        sb.append(System.lineSeparator());
    }

    private static void remove(int timesToRemove, AddRemoveCollection collection) {
        for (int i = 0; i < timesToRemove; i++) {
            sb.append(collection.remove()).append(" ");
        }

        sb.append(System.lineSeparator());
    }
}
