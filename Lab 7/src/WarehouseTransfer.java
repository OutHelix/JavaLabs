import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WarehouseTransfer {
    static class Product {
        private final int weight;

        public Product(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Loader {
        private final String name;
        private int currentWeight;

        public Loader(String name) {
            this.name = name;
            this.currentWeight = 0;
        }

        public void loadProduct(Product product) {
            currentWeight += product.getWeight();
            System.out.println(name + " is loading a product with weight: " + product.getWeight() + " kg");
        }

        public int getCurrentWeight() {
            return currentWeight;
        }

        public void resetWeight() {
            currentWeight = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(10));
        products.add(new Product(20));
        products.add(new Product(30));
        products.add(new Product(60));
        products.add(new Product(50));

        Loader[] loaders = { new Loader("Loader 1"), new Loader("Loader 2"), new Loader("Loader 3") };

        CompletableFuture<Void>[] futures = new CompletableFuture[loaders.length];

        for (int i = 0; i < loaders.length; i++) {
            int loaderIndex = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                for (Product product : products) {
                    if (loaders[loaderIndex].getCurrentWeight() + product.getWeight() <= 150) {
                        loaders[loaderIndex].loadProduct(product);
                    } else {
                        break;
                    }
                }
                System.out.println(loaders[loaderIndex].name + " is moving to the other warehouse...");
                loaders[loaderIndex].resetWeight();
            });
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);
        allFutures.get();
        System.out.println("All products have been transferred to the other warehouse.");
    }
}
