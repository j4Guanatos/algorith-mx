package j4g.sorting;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Inversion counts for merge sort algorithm.
 */
public class CountInversions {

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String file = stdin.nextLine();
        Scanner in, out;
        int cases, c = 1;
        int n;
        int[] arr, aux;
        long res;
        StringBuilder b = new StringBuilder();

        stdin.close();
        in = new Scanner(new File(String.format(BASEPATH + "%s.in", file)));
        out = new Scanner(new File(String.format(BASEPATH + "%s.out", file)));
        cases = in.nextInt();

        while (c++ <= cases) {
            res = out.nextLong();
            n = in.nextInt();
            arr = new int[n];
            aux = new int[n];
            for(int i=0; i < n; i++){
                arr[i] = in.nextInt();
            }
            System.arraycopy(arr, 0, aux, 0, n);
            b.append(String.format("| Case #%d: n = %d, data = %s | Expected = %d | Result = %d |\n",
                    c, n, cut(Arrays.toString(arr), 50),
                    swapCount(arr, aux, 0, n-1), res));
        }
        System.out.println(b.toString().trim());
    }

    private static final String BASEPATH = "11_MergeSort/io/";

    /**
     * Cut a string to the desired length if larger than.
     */
    public static String cut(String s, int len) {
        return s.length() > len ? s.substring(0, len - 3) + "..." : s;
    }

    /**
     * Utility method to print the whole or a portion of an array.
     */
    public static String toString(int[] arr, int p, int q) {
        return Arrays.toString(Arrays.copyOfRange(arr, p, q + 1));
    }

    /**
     * Utility method to check whether an array is sorted or not.
     */
    public static boolean isSorted(int[] arr, int i, int j) {
        boolean sorted = true;
        while (i < j && sorted) sorted = arr[i] <= arr[++i];
        return sorted;
    }

    public static long merge(int[] arr, int[] aux, int p, int mid, int q) {
        long count = 0;
        int i = p;
        int j = mid + 1;

        System.arraycopy(arr, p, aux, p, q - p + 1);

        for (int k = p; k <= q; k++) {
            if (i > mid)                arr[k] = aux[j++];
            else if (j > q)             arr[k] = aux[i++];
            else if (aux[i] > aux[j]) { count += mid - i + 1; arr[k] = aux[j++]; }
            else                        arr[k] = aux[i++];
        }

        return count;
    }

    public static long swapCount(int[] arr, int[] aux, int p, int q) {
        int middle = (p+q)/2;

        return isSorted(arr, p, q) ? 0 :
                swapCount(arr, aux, p, middle) + swapCount(arr, aux, middle + 1, q) + merge(arr, aux, p, middle, q);
    }
}
