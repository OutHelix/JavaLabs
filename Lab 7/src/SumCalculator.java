public class SumCalculator extends Thread {
    private final int[] array;
    private final int start;
    private final int end;
    private long partialSum;

    public SumCalculator(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    public long getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }
}

