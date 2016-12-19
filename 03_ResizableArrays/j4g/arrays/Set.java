package j4g.arrays;

/**
 * Operations defined for the array-based Set.
 */
public interface Set {

    /**
     * Intersect the current set with the passed array.
     * @param array Array of integers (in asc order).
     * @return Set instance with the result of the operation.
     */
    Set intersection(int[] array);

    /**
     * Union of the current set with the passed array.
     * @param array Array of integers (in asc order).
     * @return Set instance with the result of the operation.
     */
    Set union(int[] array);
}
