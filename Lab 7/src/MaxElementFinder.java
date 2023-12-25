public class MaxElementFinder extends Thread {
    private final int[] row;
    private int maxElement;

    public MaxElementFinder(int[] row) {
        this.row = row;
        this.maxElement = Integer.MIN_VALUE;
    }

    public int getMaxElement() {
        return maxElement;
    }

    public void run() {
        for (int element : row) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
    }
}
