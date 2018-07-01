package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl implements AddCollection {
    protected List<String> collection;

    public AddCollectionImpl() {
        collection = new ArrayList<>(100);
    }


    @Override
    public int add(String s) {
        this.collection.add(s);
        return this.collection.indexOf(s);
    }
}
