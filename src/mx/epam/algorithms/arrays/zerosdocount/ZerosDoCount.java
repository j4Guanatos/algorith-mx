/**
 * 
 */
package mx.epam.algorithms.arrays.zerosdocount;

import java.util.Arrays;

/**
 * Having an arrays of numbers, place all zeros to the left of the array (if any).
 * The operation must preserve the existing relative order between the numbers.
 * 
 * Extra:
 * An objective of this problem is to solve it in-place and in O(1N).
 * This is, without any extra arrays and in a single iteration (only one for).
 * Otherwise, give a demonstration that this is not possible.
 * 
 * @author Ernesto Espinosa.
 */
public class ZerosDoCount {
	
	/**
	 * Rearrange algorithm to put all zeros in front in-place and in O(1N).
	 * @param array Input array.
	 * @return The same array rearranged.
	 */
	public static int[] rearrange(int[] array) {
		int lastNonZero = array.length - 1;
		int i = array.length -1;
		
		while (between(i, 0, array.length)) {
			if (array[i] != 0) {
				if (i < lastNonZero) swap(array, i, lastNonZero);
				lastNonZero--;
			}
			i--;
		}
		
		return array;
	}
	
	public static int[] rearrange(int[] array, int value, boolean front) {
		int i = array.length - 1;
		int pointer = array.length - 1;
		
		while (between(i, 0, array.length)) {
			if (!(array[i] != value ^ front)) {
				if (i < pointer) swap(array, i, pointer);
				pointer--;
			}
			i--;
		}
		
		return array;
	}
	
	public static boolean between(int a, int b, int c) {
		return a >= b && a < c;
	}
	
	public static void swap(int[] array, int i, int j) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
	
	public static String test(String name, int[] result, int[] expected) {
		return String.format("%s: %15s (%s)", name, Arrays.toString(result), 
				Arrays.equals(expected, result) ? "OK  " : "FAIL");
	}
	
	public static void main(String...args) {
		int[][] inputs = { { 0 }, { 1 }, { 1, 1 }, { 1, 0, 1 }, { 0, 0, 1, 1, 0 }, 
				           { 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };
		int[][] result = { { 0 }, { 1 }, { 1, 1 }, { 0, 1, 1 }, { 0, 0, 0, 1, 1 },
						   { 0, 0, 0, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 1, 1, 1 } };
		int[] original, front, back;
				
		for (int i = 0; i < inputs.length; i++) {
			original = rearrange(Arrays.copyOf(inputs[i], inputs[i].length));
			front    = rearrange(Arrays.copyOf(inputs[i], inputs[i].length), 0, true);
			back     = rearrange(Arrays.copyOf(inputs[i], inputs[i].length), 1, false);
			
			System.out.printf("input: %15s, %s, %s, %s, expected: %15s \n",
					Arrays.toString(inputs[i]),
					test("original", original, result[i]),
					test("front",    front,    result[i]),
					test("back",     back,     result[i]),
					Arrays.toString(result[i]));
		}
	}
}
