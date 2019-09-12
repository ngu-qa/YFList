public interface MyList {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(Object o);

    boolean remove(Object o);

    boolean addAll(Object... os);

    boolean add(int index, Object o);

    boolean removeAll(Object... os);

    void clear();

    Object get(int index);

    @Override
    String toString();

}
