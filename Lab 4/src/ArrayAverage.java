public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        int count = 0;

        try {
            for (int j : arr) {
                sum += j;
                count++;
            }

            double average = (double) sum / count;
            System.out.println("Среднее арифметическое элементов массива: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом");
        }
    }
}
