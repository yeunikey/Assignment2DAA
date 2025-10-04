package metrics;

public class PerformanceTracker {

    private static long comparisons = 0;
    private static long swaps = 0;
    private static long arrayAccesses = 0;
    private static long executionTimeNanos = 0;

    public static void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        executionTimeNanos = 0;
    }

    public static void incrementComparisons(long count) {
        comparisons += count;
    }

    public static void incrementSwaps(long count) {
        swaps += count;
    }

    public static void incrementArrayAccesses(long count) {
        arrayAccesses += count;
    }

    public static void setExecutionTimeNanos(long time) {
        executionTimeNanos = time;
    }

    public static void printReport(String algorithmName, int arraySize, String arrayType) {
        System.out.println("-------------------------------------------");
        System.out.printf("Algorithm: %s\n", algorithmName);
        System.out.printf("Array Size: %d\n", arraySize);
        System.out.printf("Array Type: %s\n", arrayType);
        System.out.println("-------------------------------------------");
        System.out.printf("Execution Time: %.4f ms\n", executionTimeNanos / 1_000_000.0);
        System.out.printf("Comparisons:    %d\n", comparisons);
        System.out.printf("Swaps/Moves:    %d\n", swaps);
        System.out.printf("Array Accesses: %d\n", arrayAccesses);
        System.out.println("-------------------------------------------\n");
    }

}