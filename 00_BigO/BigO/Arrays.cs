using System;
using System.Collections.Generic;
using System.Linq;

public class Arrays{
    public static int Problem1(IEnumerable<int> array)
    {
        return ((array.Count()+1) * (array.Count() + 2) / 2) - array.Sum(); //O(N)
    }
    public static Tuple<int,int> Problem2(IEnumerable<int> array,int j, int k)
    {
        var sorted = array.OrderBy(n => n); // O(N log N)
        return new Tuple<int, int>(sorted.ElementAt(j-1) , sorted.ElementAt(sorted.Count()-k)); // O(N)
    }
}