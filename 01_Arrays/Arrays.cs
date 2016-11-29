using System;
using System.Collections.Generic;
using System.Linq;
public class Arrays
{
    public static int Problem1(IEnumerable<int> array)
    {
        return ((array.Count()+1) * (array.Count() + 2) / 2) - array.Sum(); //O(N)
    }
    public static IEnumerable<int> Problem2(IEnumerable<int> array, int j, int k)
    {
        return array.OrderBy(n => n).Where( (v,i) => i == (j - 1) || i == array.Count()-k ); // O(N log N)
    }
}