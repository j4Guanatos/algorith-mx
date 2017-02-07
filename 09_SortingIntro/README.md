# Introduction to Sorting Algorithms

Sorting is a fundamental operation in computation, as per when we treat data it may appear sequentially ordered
by a certain *key*, as phone numbers in a list (usually sorted by owner name) or data presented in web sites (as,
for example, Facebook posts according to your preferences).

Moreover, sorting can be a step of another more complex algorithm, or a prerequisite for efficient searches, as binary
search. In addition to the *sorted key*, sorted elements have extra data known as *satellite data*, which is the
information associated with the sort key and should be moved along with the key to its correct place (as the phone
number itself when phone contact data is sorted by owner).

## Average and worst cases

| Algorithm | Worst Case | Best Case | Average Case |
|-----------|------------|-----------|--------------|
| Selection Sort | O(N²) | O(N²) | O(N²) |
| Insertion Sort | O(N²) | O(N) | O(N²) |
| Merge Sort | O(N Log(N)) | O(N Log(N)) | O(N Log(N)) |
| Quick Sort | O(N²) | O(N Log(N)) | O(N²) |

## Limitations

Traditional sorting algorithms use comparison between pairs of keys to perform the sorting operation. Mathematically
is proven that any algorithm that uses comparisons will not cross the lower bound of O(N Log(N)). Other techniques use
classification over keys to perform the sorting, and with these techniques we can beat the lower bound up to O(N).

What is the amount of memory required to sort data? The most popular algorithms that in average run on O(N²) are
_in place_, which mean, that they don't require extra space to perform the sorting. Things change for algorithms
that run on O(N Log(N)). Merge sort requires extra space, but Quick sort sorts data in place.

What happens with the satellite data? When performing sorting and key comparison, the keys along with their satellite
data are _swapped_ to another position until they reach their final position according to the defined ordering. If
these swaps are performed with consecutive elements, satellite data is moved in a _stable way_, which means that if
some relative order existed before start to sort, it is preserved. The opposite is when swap is done between non
consecutive elements: the data is crossed away and the previous relative order is lost.

| Algorithm | In-Place | Stable | Average Performance |
|-----------|----------|--------|---------------------|
| Selection Sort | Yes | No | O(N²) |
| Insertion Sort | Yes | Yes | O(N²) |
| Merge Sort | No | Yes | O(N Log(N)) |
| Quick Sort | Yes | No | O(N Log(N)) |
| Holy Grail | Yes | Yes | O(N Log(N)) |

## Problems

Banco Azteca is implementing a notification system, to prevent their clients with credit cards and abonos chiquitos
y congelados to overflow the limits of their cards. They have a period of _d_ days, in which they calculate the median
of these d days and send a notification if the total amount of expenses during a day is equal or greater than two
times the calculated median.

For example, for the following data,

```
9 (days of expenses) 5 (days to calculate median)
2 3 4 2 3 6 8 4 5 (expenses data)
```

the client will receive two notifications, on day 6th and 7th. The first 5 days they will not have enough data, as they
require 5 days to calculate the median. On 6th day, median of the past expenses is (2,3,4,2,3) = 3, and the expenses are
equal to 6, so they will send notification. The same for 7th day, where median(3,4,2,3,6) = 3 and expenses are 8. For
the last two days, there will be no notifications as medians are 4 and 4 and expenses 4 and 5.
