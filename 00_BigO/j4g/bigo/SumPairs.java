package j4g.bigo;

import j4g.util.Tuple;

import java.util.stream.Stream;

/**
 * Interface to implement. Sum of all pairs that sum a target element in a given array.
 */
public interface SumPairs {

    /**
     * Finds and streams the sum of all pairs that sum the original target.
     * @param source Array source of numbers.
     * @return Stream of integer tuples.
     */
    Stream<Tuple<Integer>> find(int...source);

    /**
     * Target element to be searched for.
     * @return Target integer.
     */
    int target();
}
