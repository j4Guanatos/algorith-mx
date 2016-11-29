# Zeros do Count

Having an arrays of numbers, place all zeros to the left of the array (if any).
The operation must preserve the existing relative order between the numbers.

__Extra:__
An objective of this problem is to solve it in-place and in O(1N).
This is, without any extra arrays and in a single iteration (only one for).
Otherwise, give a demonstration that this is not possible.

__Double Extra:__
Make the number that is sent to the left configurable to be any number.
Also the side can be configurable: Can be sent left or right.

## Input 
An integer array. The size of the array can be 0 to 100,000.

Example:

```
Case 1:
1 0 3 4 0 2 0 0 1
```

## Output

An integer array with all zeros at the beginning, with the rest of the elements
in their relative original order.

```
0 0 0 0 1 3 4 2 1
```
