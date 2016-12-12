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
public class FixedSizeCollection<T> {
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
public class ResizableCollection<T> {

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
}
```

## Comparison of Increasing/Decreasing Factors

| Implementation | Increasing Factor | Decreasing Factor | Notes |
|----------------|-------------------|-------------------|-----------|
| Java ArrayList | 1.5 | No decreasing | TrimToSize used for decreasing, ensures amortized time |
| Java HashMap | 2.0 | No decreasing | Bigger factor to reduce collisions |
| Robert Sedgewick | 2.0 | check - 0.25, reduce - 0.5 | Amortized time with both factors |
| Golden Ratio | 1.618... | 0.618... | Natural factor, amortized time |

## Amortized Complexity

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
