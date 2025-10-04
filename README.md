# Assignment 2: Algorithmic Analysis and Peer Code Review

This repository contains the implementation and analysis for the **Algorithmic Analysis** assignment.  
This project focuses on **Insertion Sort** and **Selection Sort**, including their implementation, performance metric tracking, benchmarking, and a detailed peer-review analysis report.

---

## Repository Structure

```
├── pom.xml                 # Maven Project Configuration
├── docs
│   ├── analysis-report.md  # Peer review analysis of Selection Sort
│   └── performance-plots
│       └── benchmark-results.csv # Raw performance data
└── src
    ├── main
    │   └── java
    │       ├── algorithms
    │       │   ├── InsertionSort.java
    │       │   └── SelectionSort.java
    │       ├── cli
    │       │   └── BenchmarkRunner.java
    │       └── metrics
    │           └── PerformanceTracker.java
    └── test
        └── java
            └── algorithms
                ├── InsertionSortTest.java
                └── SelectionSortTest.java
```

---

## About the Algorithms

- **InsertionSort.java**  
  Implemented by *Student A*. This version is naturally efficient for nearly-sorted data, a characteristic that is highlighted in the implementation.

- **SelectionSort.java**  
  Implemented by *Student B*. This version includes an optimization for early termination if the remainder of the array is already sorted.

---

## How to Build and Run

This project uses **Apache Maven**.

### Prerequisites
- Java JDK 25 or higher
- Apache Maven

### Build the Project

Navigate to the root directory and run:

```bash
mvn clean package
```

This will compile the source code, run the tests, and create an executable JAR file in the `target/` directory named:

```
algorithmic-analysis-1.0.0-jar-with-dependencies.jar
```

---

## Run the Benchmark CLI

You can run the benchmarks for either algorithm with different input sizes and data types.

**Usage:**

```bash
java -jar target/algorithmic-analysis-1.0.0-jar-with-dependencies.jar [algorithm] [size] [type]
```

- **[algorithm]**: `insertion` or `selection`
- **[size]**: An integer representing the array size (e.g., `1000`)
- **[type]**: `random`, `sorted`, `reversed`, `nearly_sorted`

**Examples:**

```bash
# Run Insertion Sort on a randomly generated array of 5000 elements
java -jar target/algorithmic-analysis-1.0.0-jar-with-dependencies.jar insertion 5000 random

# Run Selection Sort on a reverse-sorted array of 1000 elements
java -jar target/algorithmic-analysis-1.0.0-jar-with-dependencies.jar selection 1000 reversed
```

---

## Run Tests

To run the unit tests manually:

```bash
mvn test
```

---

## Analysis Report

The detailed peer analysis of the **SelectionSort** algorithm, as required by the assignment, can be found in:

```
docs/analysis-report.md
```
