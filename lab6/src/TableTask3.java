import java.util.ArrayList;

public class TableTask3<K, V> {
    public TableTask3() {
        maxSize = 10;
        maxLoad = 0.6;
        elements = newList(maxSize);
    }

    public void put(K key, V value) {
        assert key != null : "The key must be non-null";
        int pos = hash(key);
        if (elements.get(pos) == null) {
            elements.set(pos, new Entry<>(key, value));
        } else {
            Entry<K, V> temp = elements.get(pos);
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Entry<>(key, value));
        }
        ++size;
        if (getLoad() - maxLoad > 0.01) {
            resize();
        }
    }

    public V get(K key) {
        int pos = hash(key);
        Entry<K, V> entry = elements.get(pos);
        while (entry != null) {
            if (entry.getKey().equals(key))
                return entry.getValue();
            entry = entry.getNext();
        }
        return null;
    }

    public void remove(K key) {
        int pos = hash(key);
        if (elements.get(pos) == null)
            return;
        if (elements.get(pos).getKey().equals(key)) {
            elements.set(pos, elements.get(pos).getNext());
            --size;
            return;
        }
        Entry<K, V> prev = elements.get(pos);
        Entry<K, V> current = prev.getNext();
        while (current != null && !current.getKey().equals(key)) {
            current = current.getNext();
            prev = current;
        }
        if (current != null) {
            prev.setNext(current.getNext());
            --size;
        }
    }

    private ArrayList<Entry<K, V>> newList(int size) {
        ArrayList<Entry<K, V>> temp = new ArrayList<>();

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
        ArrayList<Entry<K, V>> temp = elements;
        maxSize *= 10;
        size = 0;
        elements = newList(maxSize);
        for (Entry<K, V> entry : temp) {
            if (entry != null) {
                while (entry != null) {
                    put(entry.getKey(), entry.getValue());
                    entry = entry.getNext();
                }
            }
        }
    }

    private ArrayList<Entry<K, V>> elements;
    private int size;
    private int maxSize;
    private double maxLoad;
    @Override
    public String toString() {
        return "TableTask3 [elements=" + elements + ", size=" + size + ", maxSize=" + maxSize + ", maxLoad=" + maxLoad
                + "]";
    }
}

class Entry<K, V> {
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private Entry<K, V> next;
    private K key;
    private V value;

    public Entry<K, V> getNext() {
        return next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry [next=" + next + ", key=" + key + ", value=" + value + "]";
    }
}