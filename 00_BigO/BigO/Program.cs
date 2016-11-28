using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        IEnumerable<int> input = new int[] { 12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0 };
        int numberToSearch = 7;
        Random rand = new Random();
        for (var e = 0; e < 4; e++)
        {
            input = Enumerable.Range(0, (int)(Math.Pow(10, e)) ).Select(r => rand.Next()).Distinct();
            var sw = new Stopwatch();
            sw.Start();
            GetSumPairs(input, numberToSearch);
            sw.Stop();
            Console.WriteLine($"With e{e}, {sw.ElapsedMilliseconds}ms");
            
        }
        Console.ReadLine();
    }

    private static void GetSumPairs(IEnumerable<int> input, int numberToSearch)
    {

        var asDictionary = input.ToDictionary(n => n); // THIS is O(n)
        Func<KeyValuePair<int, int>, bool> firstNumberLessThanHalf = kvp => kvp.Key <= numberToSearch / 2;      // O(1)
        Func<KeyValuePair<int, int>, bool> itIsNotExactlyHalf = kvp => numberToSearch - kvp.Key != kvp.Key;   // O(1)
        Func<KeyValuePair<int, int>, bool> complmentExists = kvp => asDictionary.ContainsKey(numberToSearch - kvp.Key); // O(1)

        Func<KeyValuePair<int, int>, bool> canBiuldPair = kvp => (firstNumberLessThanHalf(kvp) && itIsNotExactlyHalf(kvp) && complmentExists(kvp)); // THIS is O(1), as it is already a Dictionary

        Func<KeyValuePair<int, int>, Tuple<int, int>> asTuple = kvp => new Tuple<int, int>(kvp.Key, numberToSearch - kvp.Key);  // O(1), projection

        var result = asDictionary.Where(canBiuldPair).Select(asTuple);

        Console.WriteLine(string.Format("{{ {0} }}", String.Join(",", result.Select(tuple => $"{{ {tuple.Item1},{tuple.Item2} }}")))); // O(n) enumeration
        
    }
}