# Merge Sort

In comparison to the elementary sorting algorithms (although Selection Sort can be seen as a aplication of the reduce
algorithm), Merge Sort differs from them in that uses the *divide and conquer* paradigm to attack the sorting problem.
This *divide and conquer* technique also provides the improvement in performance from N² to N Log(N), as the divide 
operation is made logarithmically against the input array. [1]

## Advantages

Merge Sort provides a running time of N Log(N) in *all cases*. Apart from it, it guarantees to be *stable*, 
preserving relative or existing ordering previous to the sort operation.
 
## Disadvantages

On the other hand, Merge Sort uses extra space proportional to the length of the entry (O(N)) to perform the sorting
operation. Selection Sort and Insertion Sort work _in place_, in contrast. Another possible disadvantage is that the 
remaining factor of this algorithm is bigger than the other elementary sorts, which really doesn't matter when the 
array is big enough. [1]

## Implementation

The _divide and conquer_ operation for this algorithm goes as follows: [1]

* Divide the entry, say from p to r, by the mid-point, say, q.
* Conquer by recursively sort the elements from p to q, and the elements from q + 1 to r.
* Combine the result of the conquer by merging the sorted array [p - q] with the sorted array [q+1 - r].

![Merge Sort Example](img/merge-sort.gif)

## References

[1] Thomas Cormen, "Algorithms Unlocked" - [Buy @ Amazon](http://a.co/dVibTKu)
[2] Robert Sedgewick, "Algorithms" - [Buy @ Amazon](http://a.co/3HMJECC)