package j4g.sorting;

import java.util.Arrays;

import static j4g.sorting.SortOps.exch;
import static j4g.sorting.SortOps.less;
import static j4g.sorting.SortOps.showA;

public class SelectionSort {

    public static Comparable[] sort(Comparable[] a) {
      int N = a.length;
      String[] all = new String[a.length];
      Arrays.fill(all, "");

      for (int i = 0; i < N; i++) {
        int min = i;
        for (int j = i + 1; j < N; j++) {
          if (less(a[j], a[min]))
            min = j;
        }
        exch(a, i, min);
        showA(a, all);
        assert isSorted(a, 0, i);
      }
      assert isSorted(a);
      return all;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
      for (int i = lo + 1; i <= hi; i++)
        if (less(a[i], a[i - 1]))
          return false;
      return true;
    }

    private static boolean isSorted(Comparable[] a) {
      return isSorted(a, 0, a.length - 1);
    }
}