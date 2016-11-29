package j4g;

import java.util.Arrays;

/**
 * Created by Ernesto_Espinosa on 11/28/2016.
 */
public class SumPairs {

    public static void quadratic(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) print(arr[i], arr[j]);
            }
        }
    }

    public static void nlogn(int[] arr, int n) {
        int index;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((index = Arrays.binarySearch(arr, n - arr[i])) >= 0 && index != i) print(arr[i], arr[index]);
        }
    }

    public static void linearNotSparsed(int[] arr, int n) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        int[] map;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        map = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            if (n - arr[i] - min > 0 && map[n - arr[i] - min] > 0) print(arr[i], n - arr[i]);
            map[arr[i] - min]++;
        }
    }

    private static void print(int a, int b) {
        System.out.println(String.format("%d %d", a, b));
    }

    public static void main(String...args) {
        linearNotSparsed(new int[] { 12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0 }, 7);
    }
}
