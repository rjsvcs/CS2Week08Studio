package util;

public interface MyList<E> extends Iterable<E> {
    // needed for ratings problem
    void add(E element);
    E get(int index);
    int size();
}