import java.util.NoSuchElementException;

public class QueueIterator<T> extends MyIterator<T> {
    public QueueIterator(final MyQueue<T> queue) {
        this.queue = queue;
        current = 0;
    }

    @Override
    public T currentItem() {
        if(isDone()) {
            throw new NoSuchElementException();
        }
        return queue.get(current);
    }

    @Override
    public void first() {
        current = 0;
    }

    @Override
    public boolean isDone() {
        return current > queue.size();
    }

    @Override
    public void next() {
        current++;
    }

    private final MyQueue<T> queue;
    private int current;
}
