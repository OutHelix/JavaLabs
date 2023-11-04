import java.util.HashMap;

// Класс продукта
class Product {
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
}

// Класс, представляющий хэш-таблицу продуктов на складе
class ProductHashTable {
    private HashMap<String, Product> productMap;

    public ProductHashTable() {
        productMap = new HashMap<>();
    }

    // Вставка продукта в хэш-таблицу
    public void insertProduct(String barcode, Product product) {
        productMap.put(barcode, product);
    }

    // Поиск продукта по штрихкоду
    public Product findProduct(String barcode) {
        return productMap.get(barcode);
    }

    // Удаление продукта по штрихкоду
    public void deleteProduct(String barcode) {
        productMap.remove(barcode);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание объекта хэш-таблицы
        ProductHashTable productHashTable = new ProductHashTable();

        // Создание объектов продуктов
        Product product1 = new Product("Apple", 1.0, 10);
        Product product2 = new Product("Banana", 0.5, 20);
        Product product3 = new Product("Orange", 0.8, 15);

        // Вставка продуктов в хэш-таблицу
        productHashTable.insertProduct("123456789", product1);
        productHashTable.insertProduct("987654321", product2);
        productHashTable.insertProduct("567890123", product3);

        // Поиск продукта по штрихкоду
        String barcode = "987654321";
        Product foundProduct = productHashTable.findProduct(barcode);
        if (foundProduct != null) {
            System.out.println("Найден продукт с штрихкодом " + barcode +
                    ": название - " + foundProduct.getName() +
                    ", цена - " + foundProduct.getPrice() +
                    ", доступное количество - " + foundProduct.getQuantity());
        } else {
            System.out.println("Продукт с штрихкодом " + barcode + " не найден");
        }

        // Удаление продукта по штрихкоду
        String barcodeToDelete = "567890123";
        productHashTable.deleteProduct(barcodeToDelete);
        System.out.println("Удален продукт с штрихкодом " + barcodeToDelete);

        // Проверка удаления продукта
        foundProduct = productHashTable.findProduct(barcodeToDelete);
        if (foundProduct != null) {
            System.out.println("Продукт с штрихкодом " + barcodeToDelete + " найден");
        } else {
            System.out.println("Продукт с штрихкодом " + barcodeToDelete + " не найден");
        }
    }
}