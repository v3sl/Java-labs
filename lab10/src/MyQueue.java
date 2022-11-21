import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultListModel;

public class MyQueue<T> implements Iterable<T> {
    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public T front() throws IndexOutOfBoundsException {
        return elements.get(0);
    }

    public T back() throws IndexOutOfBoundsException {
        return elements.get(elements.size() - 1);
    }

    public void push(T element) {
        elements.add(element);
    }

    public void pop() throws IndexOutOfBoundsException {
        elements.remove(0);
    }

    public void pushAll(Collection<? extends T> collection) throws NullPointerException {
        elements.addAll(collection);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((elements == null) ? 0 : elements.hashCode());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyQueue<T> other = (MyQueue<T>) obj;
        if (elements == null) {
            if (other.elements != null)
                return false;
        } else if (!elements.equals(other.elements))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MyQueue [elements=" + elements + "]";
    }

    @Override
    public Iterator<T> iterator() {
        // return elements.interator();
        return new Iterator<T>() {
            int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex < size() - 1;
            }

            @Override
            public T next() {
                return elements.get(++currentIndex);
            }
        };
    }

    public DefaultListModel<T> toDefaultListModel() {
        DefaultListModel<T> result = new DefaultListModel<>();
        result.addAll(elements);
        return result;
    }

    private ArrayList<T> elements = new ArrayList<>();
}