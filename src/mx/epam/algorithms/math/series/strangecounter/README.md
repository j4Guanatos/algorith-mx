# Strange Counter

Having an _strange counter_, determine the value of it after _t_ iterations of the counter.

The counter at time _t_ = 1 has the value of _k_ = 3, which is decremented as the time increases.
When the value of _k_ = 1, instead of being decremented to 0, it takes the last value of
that count-down cycle (_k_) multiplied by a factor _f_ = 2.
At this point, the value of _k_ is updated with the result of the multiplication, in this case 6.

Example:

 t | val |   | t | val |   | t  | val
 --|-----|---|---|-----|---|----|-----
 1 | 3   |   | 4 | 6   |   | 10 | 12 
 2 | 2   |   | 5 | 5   |   | 11 | 11
 3 | 1   |   | 6 | 4   |   | 12 | 10
 