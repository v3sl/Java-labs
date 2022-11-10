import java.util.ArrayList;

public class TableTask4<K, V> {
    public TableTask4() {
        maxSize = 10;
        maxLoad = 0.6;
        elements = newList(maxSize);
    }

    public void put(K key, V value) {
        assert key != null : "The key must be non-null";
        int pos = hash(key);
        if (elements.get(pos) == null) {
            elements.set(pos, new Entry(key, value));
        } else {
            Entry temp = elements.get(pos);
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Entry(key, value);
        }
        ++size;
        if (getLoad() - maxLoad > 0.01) {
            resize();
        }
    }

    public V get(K key) {
        int pos = hash(key);
        Entry entry = elements.get(pos);
        while (entry != null) {
            if (entry.key.equals(key))
                return entry.value;
            entry = entry.next;
        }
        return null;
    }

    public void remove(K key) {
        int pos = hash(key);
        if (elements.get(pos) == null)
            return;
        if (elements.get(pos).key.equals(key)) {
            elements.set(pos, elements.get(pos).next);
            --size;
            return;
        }
        Entry prev = elements.get(pos);
        Entry current = prev.next;
        while (current != null && !current.key.equals(key)) {
            current = current.next;
            prev = current;
        }
        if (current != null) {
            prev.next = (current.next);
            --size;
        }
    }

    private ArrayList<Entry> newList(int size) {
        ArrayList<Entry> temp = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            temp.add(null);
        }

        return temp;
    }

    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % maxSize;
    }

    private double getLoad() {
        return (double) size / (double) maxSize;
    }

    private void resize() {
        ArrayList<Entry> temp = elements;
        maxSize *= 10;
        size = 0;
        elements = newList(maxSize);
        for (Entry entry : temp) {
            if (entry != null) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
    }

    private ArrayList<Entry> elements;
    private int size;
    private int maxSize;
    private double maxLoad;

    @Override
    public String toString() {
        return "TableTask3 [elements=" + elements + ", size=" + size + ", maxSize=" + maxSize + ", maxLoad=" + maxLoad
                + "]";
    }

    private class Entry {
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry next;
        public K key;
        public V value;

        @Override
        public String toString() {
            return "Entry [next=" + next + ", key=" + key + ", value=" + value + "]";
        }
    }
}
