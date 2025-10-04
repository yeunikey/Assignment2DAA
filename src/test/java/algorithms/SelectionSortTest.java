package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    private SelectionSort sorter;

    @BeforeEach
    void setUp() {
        sorter = new SelectionSort();
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {10, 20, 30, 40, 50};
        int[] expected = {10, 20, 30, 40, 50};
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {50, 40, 30, 20, 10};
        int[] expected = {10, 20, 30, 40, 50};
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRandomArray() {
        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {5, 2, 8, 2, 5, 1};
        int[] expected = {1, 2, 2, 5, 5, 8};
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithNegativeNumbers() {
        int[] arr = {-5, 2, -8, 0, 5, -1};
        int[] expected = {-8, -5, -1, 0, 2, 5};
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

}
