# Heapsort

Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element.

Like merge sort, but unlike insertion sort, heapsort’s running time is O(n lg n). Like insertion sort, but unlike merge sort, heapsort sorts in place: only a constant number of array elements are stored outside the input array at any time.

Heapsort also introduces another algorithm design technique: using a data struc- ture, in this case one we call a “heap,” to manage information. Not only is the heap data structure useful for heapsort, but it also makes an efficient priority queue.

## What is a Binary Heap?

Let us first define a Complete Binary Tree. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

A Binary Heap is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. The former is called as max heap and the latter is called min heap.

## Priority Queue

Many applications require that we process items having keys in order, but not necessarily in full sorted order and not necessarily all at once. Often, we collect a set of items, then process the one with the largest key, then perhaps collect more items, then process the one with the current largest key, and so forth. An appropriate data type in such an environment supports two operations: remove the maximum and insert. Such a data type is called a priority queue.

## Heap Sort Algorithm for sorting in increasing order

1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.

http://algs4.cs.princeton.edu/24pq/
http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap07.htm

## Sources
http://quiz.geeksforgeeks.org/heap-sort/
Introduction to Algorithms, 3rd Ed (Thomas H. Cormen, Clifford Stein, Ronald L. Rivest, Charles E. Leiserson)
Algorithms, 4th Ed (Robert Sedgewick, Kevin Wayne)