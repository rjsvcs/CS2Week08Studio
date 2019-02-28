package util;

import java.util.Iterator;

public class MyListIterator<E> implements Iterator<E> {

    private final MyList<E> list;
    private int position;

    MyListIterator(MyList<E> list) {
        this.list = list;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public E next() {
        return list.get(position++);
    }
}
