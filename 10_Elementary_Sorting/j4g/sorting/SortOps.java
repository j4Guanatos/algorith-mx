package j4g.sorting;

/**
 * Created by Ernesto_Espinosa on 3/6/2017.
 */
public final class SortOps {

    private SortOps() { throw new UnsupportedOperationException(); }

    public static <T> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static void showA(Comparable[] a, String[] all) {
        for (int i = 0; i < a.length; i++) {
            all[i] += "  " + a[i];
        }
    }
}
