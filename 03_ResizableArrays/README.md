# Algorith-MX Group - Session 3
# Topic: Resizable Arrays

## Overview 

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

One simple strategy to maintain a dynamic size of an array-based structure is to calculate the maximum size the
collection can be. For example the following API will maintain a fixed size array of strings, and it can be used to
implement a LIFO structure (code link to [FixedSizeCollection](j4g/arrays/FixedSizeCollection.java)):

```
public class FixedSizeCollection<T> implements RandomAccess {
   private T[] elements;
   private int size = 0;
   
   public FixedSizeCollection(int maxSize) {
      elements = (T[]) new Object[maxSize];
   }
   
   public void add(T element) {
      elements[size++] = element;
   }
   
   public T removeLast() {
      T element = elements[--size];
      elements[size] = null;
      return element;
   }
   
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public boolean isFull() {
      return size == elements.length;
   }
   
   public T get(int index) {
       if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
       return elements[index];
   }
}
```

The following problems can be find with this class:

* Risk of index overflow: Client should be aware of being within the limits (0 - maxSize).
* Wasted amount of memory: Client will need to cover the memory worst case even if it doesn't happen.

In such cases, the solution is to initialize the array size to an arbitrary value, and then re-create the array when
needed copying the existing values into the new array. This is driven by an _increasing/decreasing factor_, which will
indicate how much the array size is increased and when to reduce the array size.

We can see that in action in the modified version of the FixedSizeCollection, called 
[ResizableCollection](j4g/arrays/ResizableCollection) (2). Each time the inner array is full, a new array of doubled size
is created and populated with the existing elements prior to add a new one, to ensure enough capacity. Each time the
inner array is quarter filled, a new array with halved size is created and filled with the existing elements. Note that
the comparison is done against the quarter of capacity and the resize is half the array size, this is in order to avoid 
to resize with consecutive remove/add operations at the half of capacity, resizing the array in both sides.

```
public class ResizableCollection<T> implements RandomAccess {

    private static final int INITIAL_SIZE = 4;
    private T[] elements;
    private int size = 0;

    public ResizableCollection() {
        elements = buildGenericArray(INITIAL_SIZE);
    }

    public static <T> T[] buildGenericArray(int size) {
        return (T[]) new Object[size];
    }

    public void add(T element) {
        if (size == elements.length) resizeTo(elements.length * 2);
        elements[size++] = element;
    }

    public T removeLast() {
        T element = elements[--size];
        elements[size] = null;
        if (size > 0 && size == elements.length / 4) resizeTo(elements.length / 2);
        return element;
    }

    private void resizeTo(int newSize) {
        T[] newArray = buildGenericArray(newSize);
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return elements[index];
    }
}
```

## Comparison of Increasing/Decreasing Factors

| Implementation | Increasing Factor | Decreasing Factor | Notes |
|----------------|-------------------|-------------------|-----------|
| Java ArrayList | 1.5 | No decreasing | TrimToSize used for decreasing, ensures amortized time |
| Java HashMap | 2.0 | No decreasing | Bigger factor to reduce collisions |
| Robert Sedgewick | 2.0 | check - 0.25, reduce - 0.5 | Amortized time with both factors |
| Golden Ratio | 1.618... | 0.618... | Optimal factor, amortized time |

The reason why in general 1.5 is preferred over a factor of 2.0 is because we would want to reuse the holes in memory
left by the resizing operation. Example:

#### Resizing with a factor of 2

| Size | New Allocation | Freed memory | Memory Hole |
|------|----------------|--------------|-------------|
| 16 bytes | 32 bytes | 16 bytes | 16 bytes |
| 32 bytes | 64 bytes | 32 bytes | 48 bytes (if 16 and 32 were adjacent) |
| 64 bytes | 128 bytes | 64 bytes | 112 bytes (not enough to be reused) |

#### Resizing with a factor of 1.5

| Size | New Allocation | Freed memory | Memory Hole |
|------|----------------|--------------|-------------|
| 16 bytes | 24 bytes | 16 bytes | 16 bytes |
| 32 bytes | 36 bytes | 24 bytes | 40 bytes (if 16 and 24 were adjacent) |
| 64 bytes | 54 bytes | 36 bytes | 76 bytes (size enough to be reused) |

Ideally, the limit will be found at the _Golden Ratio_ which solves the equation x^(n-1) = x^(n+1) - x^n:

```
1 + x + ... + x^(n-2) = x^n
```

Each iteration request x^(n+1) memory to allocate the new array, which means that for the next iteration (x^(n+2)) we
would want to have the previous sum equal to reuse the space.

Discard the 1 element by being dominated by the highest polynomial factor and then solving the equation results in the
Golden Ratio as the optimal reusing memory upper bound for resizing factors.

```
x^(n-1) = x^(n+1) - x^n  ->  1 = x^2 - x  ->  x = 1/2 * (1 + sqrt(5)) = 1.618...
```

## Amortized Complexity

Which is the complexity of insert/remove operations in a resizable array? A way to provide a performance guarantee is to
amortize the cost, keeping track of the total cost of all operations, divided by the number of operations. We allow some
expensive operations (to copy the array contents into the new array), but keeping the average cost low.

In the case of N being a power of 2, how many array entries are accessed for N consecutive calls to add()? We have N
accesses in constant time (one per push) plus the resizing operations in terms of a sum of powers of 2 up to 2N:

```
N + 2 + 4 + 8 + ... + 2N = 5N - 4.
```

This sum divided by N operations results in an amortized constant complexity.

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
