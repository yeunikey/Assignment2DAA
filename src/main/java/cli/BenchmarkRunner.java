package cli;

import algorithms.InsertionSort;
import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Использование: java BenchmarkRunner [алгоритм] [размер] [тип]");
            System.err.println("  [алгоритм]: 'insertion' или 'selection'");
            System.err.println("  [размер]: целое число > 0");
            System.err.println("  [тип]: 'random', 'sorted', 'reversed', 'nearly_sorted'");
            System.exit(1);
        }

        try {
            String algorithm = args[0].toLowerCase();
            int size = Integer.parseInt(args[1]);
            String type = args[2].toLowerCase();

            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным.");
            }

            int[] data = generateData(size, type);
            PerformanceTracker.reset();

            long startTime = System.nanoTime();

            if ("insertion".equals(algorithm)) {
                InsertionSort sorter = new InsertionSort();
                sorter.sort(data);
            } else if ("selection".equals(algorithm)) {
                SelectionSort sorter = new SelectionSort();
                sorter.sort(data);
            } else {
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
            }

            long endTime = System.nanoTime();
            PerformanceTracker.setExecutionTimeNanos(endTime - startTime);
            PerformanceTracker.printReport(algorithm, size, type);

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат числа для размера.");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }

    private static int[] generateData(int size, String type) {
        int[] arr = new int[size];
        Random rand = new Random();

        switch (type) {
            case "random":
                for (int i = 0; i < size; i++) {
                    arr[i] = rand.nextInt(size * 10);
                }
                break;
            case "sorted":
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
                break;
            case "reversed":
                for (int i = 0; i < size; i++) {
                    arr[i] = size - 1 - i;
                }
                break;
            case "nearly_sorted":
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
                int swaps = (int) (size * 0.1);
                for (int i = 0; i < swaps; i++) {
                    int idx1 = rand.nextInt(size);
                    int idx2 = rand.nextInt(size);
                    int temp = arr[idx1];
                    arr[idx1] = arr[idx2];
                    arr[idx2] = temp;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown data type: " + type);
        }
        return arr;
    }

}

