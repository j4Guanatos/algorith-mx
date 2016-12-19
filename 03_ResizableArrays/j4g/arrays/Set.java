package j4g.arrays;

/**
 * Operations defined for the array-based Set.
 */
public interface Set {

    /**
     * 
     * @param array
     * @return
     */
    Set intersection(int[] array);

    Set union(int[] array);

    Set intersection(Set set);

    Set union(Set set);
}
