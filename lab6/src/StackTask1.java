import java.util.ArrayList;

public class StackTask1<E> {

    public StackTask1() {
        elements = new ArrayList<>();
    }

    public void push(E element) {
        elements.add(element);
    }

    public E pop() {
        E element = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return element;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private ArrayList<E> elements;
}