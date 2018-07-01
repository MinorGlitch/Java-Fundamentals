package collectionHierarchy;

import java.util.List;

public class AddRemoveCollectionImpl extends AddCollectionImpl implements AddRemoveCollection {

    public AddRemoveCollectionImpl() {
        super();
    }

    @Override
    public String remove() {
        return super.collection.remove(super.collection.size() - 1);
    }
}
