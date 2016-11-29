# Strange Counter

Having an _strange counter_, determine the value of it after _t_ iterations of the counter.

The counter at time _t_ = 1 has the value of _k_ = 3, which is decremented as the time increases.
When the value of _k_ = 1, instead of being decremented to 0, it takes the last value of
that count-down cycle (_k_) multiplied by a factor _f_ = 2.
At this point, the value of _k_ is updated with the result of the multiplication, in this case 6.

Example:

| t | val | t | val | t  | val |
|---|-----|---|-----|----|-----|
| 1 | 3   | 4 | 6   | 10 | 12  |
| 2 | 2   | 5 | 5   | 11 | 11  |
| 3 | 1   | 6 | 4   | 12 | 10  |
|   |     | 7 | 3   | 13 | 9   |
|   |     | 8 | 2   | 14 | 8   |
|   |     | 9 | 1   | 15 | 7   |
|   |     |   |     | 16 | 6   |
|   |     |   |     | 17 | 5   |
|   |     |   |     | 18 | 4   |
|   |     |   |     | 19 | 3   |
|   |     |   |     | 20 | 2   |
|   |     |   |     | 21 | 1   |
 
The problem is, having _t_, determine the value of _val_, for _k_ = 3 and _f_ = 2.

Extra:
The above problem has the values of _k_ and _f_ fixed. Solve the problem with _k_ and _f_ variables.


## Input 
The value of _t_ as integer.

Example:

```
Case 1:
1
Case 2: 
6
Case 3:
17
```

## Output

An integer representing the value of _val_ corresponding to _t_.

```
Case 1:
3
Case 2:
4
Case 3:
5
```
