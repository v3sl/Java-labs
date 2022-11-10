import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class StackTask2_1<E> {

    public StackTask2_1(Class<E> type) {
        elements = (E[]) Array.newInstance(type, DEFAULT_INITIAL_CAPACITY);
    }

    public void push(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
}