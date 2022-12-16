public class CountVisitor<T> implements Visitor<T> {
    private int count = 0;

    @Override
    public void visit(MyQueue<T> queue) {
        QueueIterator<T> iterator = new QueueIterator<T>(queue);
        while (!iterator.isDone()) {
            iterator.currentItem();
            iterator.next();
            ++count;
        }
    }

    public int getCount() {
        return count;
    }
}
