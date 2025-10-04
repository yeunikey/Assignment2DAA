package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                PerformanceTracker.incrementComparisons(1);
                PerformanceTracker.incrementArrayAccesses(2);
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                PerformanceTracker.incrementSwaps(1);
                PerformanceTracker.incrementArrayAccesses(4);
            }

            if (isSorted(arr, i + 1)) {
                break;
            }
        }
    }

    private boolean isSorted(int[] arr, int startIndex) {
        for (int k = startIndex; k < arr.length - 1; k++) {
            PerformanceTracker.incrementComparisons(1);
            PerformanceTracker.incrementArrayAccesses(2);
            if (arr[k] > arr[k + 1]) {
                return false;
            }
        }
        return true;
    }

}
