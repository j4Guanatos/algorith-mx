# Elementary Sorting


## Overview

##Selection Sort
* _in place_ (except for a temp variable for exchanges)
* The algorithm divides the input list into items already sorted items remaining to be sorted
* It works by repeatedly _select_ing the smallest(for increasing sort) remaining item. 
```
var i = 0
Repeat
  the next smallest item in the array
  Exchange it with the entry in the ith position
  Increase i
until the entire array is sorted (i.e. end of array reached)
```

##Demo
(see https://visualgo.net/sorting)

##Running time
Number of compares:  *(𝑵 – 𝟏)+ (𝑵 – 𝟐)+ … + 𝟏 + 𝟎 =𝒏(𝒏 - 𝟏)/𝟐  ~  𝑵^𝟐/ 𝟐*

Number of exchanges:  𝑵

The number of compares and exchanges made by selection sort does not depend on the order of the input.
