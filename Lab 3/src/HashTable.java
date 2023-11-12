import java.util.LinkedList;

public class HashTable {
    private static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Product: " + name + ". Price is " + price + ". Quantity is " + quantity + ".";
        }
    }

    private final LinkedList<Entry<String, Product>>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    public void put(String key, Product product) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<String, Product> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(product);
                return;
            }
        }
        table[index].add(new Entry<>(key, product));
        size++;
    }

    public Product get(String key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<String, Product> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<String, Product> entry : table[index]) {
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

    private int hash(String key) {
        return Math.abs(key.hashCode() % table.length);
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
        HashTable table = new HashTable(10);

        Product product1 = new Product("apple", 1.99, 10);
        Product product2 = new Product("banana", 2.99, 5);
        Product product3 = new Product("jam", 4.99, 2);
        Product product4 = new Product("kiwi", 3.99, 8);

        table.put("apple", product1);
        table.put("banana", product2);
        table.put("jam", product3);
        table.put("kiwi", product4);

        System.out.println(table.get("jam"));
        System.out.println(table.get("kiwi"));
        table.remove("jam");
        System.out.println(table.get("jam"));
        table.remove("banana");

        table.remove("apple");

        System.out.println(table.size());
        System.out.println(table.isEmpty());
    }
}