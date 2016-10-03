# Threes and Fives

You will be given a number _n_. Find a number _m_ that match the following rules:

* _m_ has _n_ digits.
* _m_ can have only 5's and 3's.
* The number of 5's is divisible by 3.
* The number of 3's is divisible by 5.
* If there are multiple combinations, choose the biggest number possible.
* If there is no possible combination, return -1.

__Extra__: The algorithm is proven to be solved in O(1).

## Sample input:

You will receive a number _t_ which is the number of test cases.
Following there will be _t_ lines containing the number _n_ for each test case.

4
1
3
5
11

## Sample Output:

Print one line containing the corresponding _m_ for each test case.

-1
555
33333
55555533333
