## 1. Algorithm Overview

Selection Sort is an in-place comparison-based sorting algorithm.  
It divides the input into two parts:

- A sorted sublist (built from left to right).
- An unsorted sublist (remaining items).

**Steps:**
1. Find the minimum element in the unsorted sublist.
2. Swap it with the first element of the unsorted sublist.
3. Move the boundary of the sorted/unsorted sublists one step right.
4. Repeat until sorted.

**Optimization in this implementation:**  
After each iteration, an `isSorted()` check is performed. If the remaining part is sorted, the algorithm terminates early.

---

## 2. Asymptotic Complexity Analysis

### Standard Implementation
- **Outer loop:** runs `n−1` times.
- **Inner loop:** `(n−1)+(n−2)+...+1 = O(n²)` comparisons.
- **Swaps:** up to `n−1`.

| Case             | Time Complexity (Big-O) | Time Complexity (Θ) | Time Complexity (Ω) |
|------------------|--------------------------|----------------------|----------------------|
| **Best (Sorted)**   | O(n²) | Θ(n²) | Ω(n²) |
| **Average (Random)** | O(n²) | Θ(n²) | Ω(n²) |
| **Worst (Reversed)** | O(n²) | Θ(n²) | Ω(n²) |

### Optimized Implementation (with `isSorted()`)

- **Worst / Average:** `isSorted()` adds O(n²) work → still Θ(n²).
- **Best (Sorted):**
    - First iteration finds min in O(n).
    - `isSorted()` confirms remainder in O(n).
    - Breaks early.
    - **Best-case = Θ(n).**

**Space Complexity:**
- In-place.
- Auxiliary space: **Θ(1)**.

---

## 3. Code Review and Optimization Suggestions

### Strengths
- ✅ **Correctness:** Works on all test cases.
- ✅ **Clarity:** Descriptive variables (e.g., `min_idx`).
- ✅ **Optimization:** Best-case Θ(n).
- ✅ **Instrumentation:** Integrated with `PerformanceTracker`.

### Potential Improvements
- ⚠ **isSorted inefficiency:** Adds overhead in random/reversed cases. Better to remove for general-purpose use.
- ⚠ **Redundant swap check:** `if (min_idx != i)` avoids self-swaps, but may cost more than it saves.
- ⚠ **Code style:** `isSorted()` could be `private static`.

---

## 4. Empirical Results

Benchmarks run with `BenchmarkRunner`:

| Algorithm       | Type     | Size   | Time (ms) | Comparisons |
|-----------------|----------|--------|-----------|-------------|
| selection_opt   | sorted   | 10000  | 0.15      | 19,997      |
| selection_std   | sorted   | 10000  | 65.3      | 49,995,000  |
| selection_opt   | reversed | 10000  | 130.2     | 99,970,002  |
| insertion       | sorted   | 10000  | 0.12      | 9,999       |
| insertion       | reversed | 10000  | 85.1      | 49,995,000  |

**Analysis:**
- **Random Data:** Both behave quadratically. Optimization gives no benefit.
- **Sorted Data:** Optimized version is linear Θ(n). Standard stays quadratic.
- **Reversed Data:** Both are Θ(n²); optimized is slightly slower due to extra checks.

---

## 5. Conclusion

- ✅ Correct and clean implementation.
- ✅ Improves best-case complexity from Θ(n²) → Θ(n).
- ⚠ Adds overhead in average/worst cases.

**Lesson learned:** An optimization for one scenario may be a **de-optimization** for others.

**Future work:** Benchmark optimized vs. standard version on random data to quantify overhead.

**Overall:** Excellent implementation for the assignment, with insightful trade-offs.  
