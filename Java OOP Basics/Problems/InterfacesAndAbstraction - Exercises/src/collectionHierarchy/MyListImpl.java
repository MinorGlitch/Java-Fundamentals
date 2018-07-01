package collectionHierarchy;

public class MyListImpl extends AddRemoveCollectionImpl implements MyList {

    public MyListImpl() {
        super();
    }

    @Override
    public String remove() {
        return super.collection.remove(0);
    }

}
