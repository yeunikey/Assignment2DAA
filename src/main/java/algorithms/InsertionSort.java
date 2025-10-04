package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            PerformanceTracker.incrementArrayAccesses(1);
            int j = i - 1;

            while (j >= 0) {
                PerformanceTracker.incrementArrayAccesses(1);
                PerformanceTracker.incrementComparisons(1);
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    PerformanceTracker.incrementSwaps(1);
                    PerformanceTracker.incrementArrayAccesses(2);
                    j = j - 1;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            PerformanceTracker.incrementArrayAccesses(1);
        }
    }

}