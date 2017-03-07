package j4g.sorting;

import java.util.Arrays;

import static j4g.sorting.SortOps.less;
import static j4g.sorting.SortOps.exch;
import static j4g.sorting.SortOps.showA;

public class InsertionSort {// extends edu.princeton.cs.algs4.Insertion {

    // is v < w ?

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    /***************************************************************************
     * Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    public static String[] sort(Comparable[] a) {
        int N = a.length;
        String[] all = new String[a.length];
        Arrays.fill(all, "");
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                showA(a, all);
            }

            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
        return all;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "  ");
        }
    }
}