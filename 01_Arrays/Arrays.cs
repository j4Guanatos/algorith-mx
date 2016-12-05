using System;
using System.Collections.Generic;
using System.Linq;

public class Arrays{
    public static int Problem1(int[] array)
    {
		var n = array.Length+1; // O(1)
        return (n * (n+1) / 2) - array.Sum(); //O(N)
    }
    public static Tuple<int,int> Problem2(int[] array,int j, int k)
    {
        var sorted = array.OrderBy(n => n).ToArray(); // O(N log N)
        return new Tuple<int, int>(sorted[j-1] , sorted[sorted.Length-k]); // O(1)
    }
	public static void Main(string[] args){
		int[] input1 = new int[]{9,3,7,2,6,8,4,5,10};
		string joined = String.Join(",",input1);
		Console.WriteLine($"For input [{joined}], the missing number is: {Problem1(input1)}");
		int[] input2 = new int[]{9,10,2,3,6,8,1,4,5};
		joined = String.Join(",",input2);
		int j = 2;
		int k = 4;
		var result = Problem2(input2,j,k);
		Console.WriteLine($"For input [{joined}], j={j}, k={k}, the jth smallest is:{result.Item1} and the kth largest is: {result.Item2}");
	}
}