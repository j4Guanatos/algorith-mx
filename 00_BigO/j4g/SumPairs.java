package j4g;

import j4g.util.IntTuple;
import j4g.util.SameTypeTuple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Ernesto_Espinosa on 11/28/2016.
 */
public class SumPairs {

    private int target;

    private SumPairs(int target) {
        this.target = target;
    }

    public static SumPairs find(int target) {
        return new SumPairs(target);
    }

    public Stream<IntTuple> usingQuadratic(int...arr) {
        return IntStream.range(0, arr.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, arr.length).mapToObj(j -> IntTuple.get(i, j)))
                .filter(t -> t.left() < t.right())
                .filter(t -> arr[t.left()] + arr[t.right()] == target)
                .map(t -> IntTuple.get(arr[t.left()], arr[t.right()]));
    }

    public Stream<IntTuple> usingSorting(int...arr) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        return IntStream.range(0, arr.length)
                .mapToObj(i -> IntTuple.get(i, Arrays.binarySearch(sorted, target - sorted[i])))
                .filter(t -> t.right() >= 0)
                .filter(t -> t.left() < t.right())
                .map(t -> IntTuple.get(sorted[t.left()], sorted[t.right()]));
    }

    public Stream<IntTuple> usingLinearByRange(int...arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        final int[] map = new int[max - min + 1];

        Arrays.stream(arr).forEach(i -> map[i - min]++);

        return IntStream.range(min, max)
                    .filter(i -> target - i - min >= 0 && map[target - i - min] > 0)
                    .filter(i -> i < target - i)
                    .mapToObj(i -> IntTuple.get(i, target - i));
    }

    public static void main(String...args) {
        SumPairs finder = SumPairs.find(7);

        finder.usingQuadratic(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0).forEach(System.out::print);
        System.out.println();
        finder.usingSorting(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0).forEach(System.out::print);
        System.out.println();
        finder.usingLinearByRange(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0).forEach(System.out::print);
    }
}
