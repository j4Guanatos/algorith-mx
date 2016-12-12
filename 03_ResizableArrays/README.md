# Algorith-MX Group - Session 3
# Topic: Resizable Arrays

## Background 

The choice of a data structure is a fundamental step in solving coding problems.
Selecting the right data structure can make big differences in the complexity of the resulting implementation. Pick
the right data implementation, and your task will be easy to program. Pick the wrong representation, and big amounts of
code will be needed to cover the initial lousy decision (1).

As we will see in future sessions, fundamental data structures, such as Bags, Stacks, Queues, Lists, Sets, etc. are
required to be dynamic in terms of types of objects and size. The former is achievable from the roots of the programming
language used (i.e. Generics in Java), but the second needs a programming and mathematical focus to find the optimal 
implementation that supports effectively dynamic addition and deletion of elements.

In scripting languages, such as Javascript and Python, arrays are dynamic in size (in fact, they are using a 
dictionary-like structure instead of an array). But in compiled languages as Java, arrays are fixed length and cannot be
changed dynamically during runtime. Then, how dynamic structures, such as ArrayList, maintain add/remove operations?

## Resizing Arrays Strategy



## Comparison of Increasing/Decreasing Factors

## Amortized Complexity

## Usage

## Coding Task

Given an initial array of integers, in ascending order, perform consecutive set operations against other arrays,
until the arrays are reduced to a single one.

### Assumptions & Constraints

* Valid operations are i (intersection) and u (union).
* All the input arrays are in ascending order.
* Compute the solution in O(n).
* You are not allowed to use any collection framework (i.e. Java ArrayList, HashMap), but only array manipulation.
* Each array (input or output) should be treated as a sorted set of integers (no duplicates)

### Input Example

The first line will be the original array.
Following arbitrary number of lines will have an operation id (i or u), indicating the operation to perform, 
followed by an integer array of arbitrary size, in ascending order. 

```
1 5 9 10 17 20 23
i 2 4 6 8 10 12 14 16 18 20
u 3 9 18 27
u 2 3 5 7 11 13 17
```

### Output Example

```
2 3 5 7 9 10 11 13 17 18 20 27
```

### Sample Case Step by Step

* The original array intersected with the first line will result in: 10 20
* The union between the above result and the second line will result in: 3 9 10 18 20 27
* The union between the above result and the third line will result in: 2 3 5 7 9 10 11 13 17 18 20 27

## References

* (1) Steven Skiena, Miguel Revilla, "Programming Challenges".
* (2) Robert Sedgewick, "Algorithms", Fourth Edition.

#### Let's keep our code clean and beautiful!
