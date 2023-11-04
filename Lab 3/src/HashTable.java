import java.util.LinkedList;

public class HashTable<K, V> {
    private final LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable(int inputInt) {
        table = new LinkedList[inputInt];
        size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>(10);
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 4);
        table.put("four", 3);

        System.out.println(table.get("three"));
        table.remove("two");
        table.remove("three");
        table.remove("one");
        System.out.println(table.size());
        System.out.println(table.isEmpty());
    }
}
