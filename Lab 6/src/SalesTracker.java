import java.util.*;

public class SalesTracker {
    private HashMap<String, Integer> sales;

    public SalesTracker() {
        sales = new HashMap<>();
    }

    // Метод для добавления продажи товара
    public void addSale(String item, int quantity) {
        int currentQuantity = sales.getOrDefault(item, 0);
        sales.put(item, currentQuantity + quantity);
    }

    // Метод для вывода списка проданных товаров
    public void listSales() {
        System.out.println("Список проданных товаров:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println("Товар: " + entry.getKey() + ", Количество продаж: " + entry.getValue());
        }
    }

    // Метод для вычисления общей суммы продаж
    public int totalSales() {
        int total = 0;
        for (int quantity : sales.values()) {
            total += quantity;
        }
        return total;
    }

    // Метод для определения наиболее популярного товара
    public String mostPopularItem() {
        String mostPopular = "";
        int maxSales = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        // Добавление продаж
        tracker.addSale("Товар1", 5);
        tracker.addSale("Товар2", 3);
        tracker.addSale("Товар1", 2);
        tracker.addSale("Товар3", 7);
        tracker.addSale("Товар2", 4);

        // Вывод списка проданных товаров
        tracker.listSales();

        // Вывод общей суммы продаж
        System.out.println("Общая сумма продаж: " + tracker.totalSales());

        // Вывод наиболее популярного товара
        System.out.println("Наиболее популярный товар: " + tracker.mostPopularItem());
    }
}