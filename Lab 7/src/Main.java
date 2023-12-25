public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        System.out.println("-----------------");
        int[] arr = {1, 2, 3, 4, 5};
        int mid = arr.length / 2;

        // Создание потоков для каждой половины массива
        SumCalculator thread1 = new SumCalculator(arr, 0, mid);
        SumCalculator thread2 = new SumCalculator(arr, mid, arr.length);

        // Запуск потоков
        thread1.start();
        thread2.start();

        try {
            // Ожидание завершения работы потоков
            thread1.join();
            thread2.join();

            // Получение результатов вычислений
            long result = thread1.getPartialSum() + thread2.getPartialSum();
            System.out.println("Сумма элементов массива: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------");
        System.out.println("Задача 2");
        System.out.println("-----------------");

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int numRows = matrix.length;

        MaxElementFinder[] threads = new MaxElementFinder[numRows];

        // Создаем и запускаем потоки для каждой строки матрицы
        for (int i = 0; i < numRows; i++) {
            threads[i] = new MaxElementFinder(matrix[i]);
            threads[i].start();
        }

        int maxElement = Integer.MIN_VALUE;

        // Дожидаемся завершения всех потоков и сравниваем результаты
        for (MaxElementFinder thread : threads) {
            try {
                thread.join();
                int threadMax = thread.getMaxElement();
                if (threadMax > maxElement) {
                    maxElement = threadMax;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Наибольший элемент в матрице: " + maxElement);
        System.out.println("-----------------");
    }
}
