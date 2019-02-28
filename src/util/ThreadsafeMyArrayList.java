package util;

import java.util.Arrays;
import java.util.Iterator;

public class ThreadsafeMyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;

    public ThreadsafeMyArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    public synchronized void add(E element) {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, size*2);
        }
        elements[size] = element;
        size++;
    }

    @Override
    public synchronized E get(int index) {
        return (E)elements[index];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<>(this);
    }
}
