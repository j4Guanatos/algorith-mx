# Algorith-MX Group - Session 3
# Topic: Resizable Arrays

## Background 

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
* This result union the second line will result in: 3 9 10 18 20 27
* This result union the third line will result in: 2 3 5 7 9 10 11 13 17 18 20 27

#### Let's keep our code clean and beautiful!
