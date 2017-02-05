package j4g.bigo;

import j4g.util.IntTuple;
import j4g.util.Timer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Ernesto_Espinosa on 1/31/2017.
 */
public final class Algorithms {

    // Avoid instantiability.
    private Algorithms() { throw new UnsupportedOperationException(); }

    public static final String N2 = "Quadratic/Brute Force";
    public static final String NLOGN = "Solution using Sorting";
    public static final String N = "Linear solution";
    public static final String RANGED = "Linear by Range";

    static {
        SumPairsFactory.register(N2, i -> new QuadraticSumPairs(i));
        SumPairsFactory.register(NLOGN, i -> new SortedSumPairs(i));
        SumPairsFactory.register(N, i -> new LinearSumPairs(i));
        SumPairsFactory.register(RANGED, i -> new RangedSumPairs(i));
    }

    private static abstract class BaseSumPairs implements SumPairs {

        private int target;

        @Override
        public int target() { return target; }
        protected BaseSumPairs(int target) { this.target = target; }
    }

    private static class QuadraticSumPairs extends BaseSumPairs {

        protected QuadraticSumPairs(int target) { super(target); }
        public Stream<IntTuple> find(int...source) {
            return IntStream.range(0, source.length)
                    .boxed()
                    .flatMap(i -> IntStream.range(0, source.length).mapToObj(j -> IntTuple.get(i, j)))
                    .filter(t -> t.X < t.Y)
                    .filter(t -> source[t.X] + source[t.Y] == target())
                    .map(t -> IntTuple.get(source[t.X], source[t.Y]));
        }
    }

    private static class SortedSumPairs extends BaseSumPairs {
        protected SortedSumPairs(int target) { super(target); }
        public Stream<IntTuple> find(int...source) {
            int[] sorted = Arrays.stream(source).sorted().toArray();
            return IntStream.range(0, source.length)
                    .mapToObj(i -> IntTuple.get(i, Arrays.binarySearch(sorted, target() - sorted[i])))
                    .filter(t -> t.Y >= 0)
                    .filter(t -> t.X < t.Y)
                    .map(t -> IntTuple.get(sorted[t.X], sorted[t.Y]));
        }
    }

    private static class LinearSumPairs extends BaseSumPairs {
        protected LinearSumPairs(int target) { super(target); }
        public Stream<IntTuple> find(int...source) {
            Map<Integer, Long> counters =
                    Arrays.stream(source)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            return IntStream.range(0, source.length)
                    .filter(i -> source[i] < target() - source[i])
                    .filter(i -> counters.containsKey(target() - source[i]))
                    .mapToObj(i -> IntTuple.get(source[i], target() - source[i]));
        }
    }

    private static class RangedSumPairs extends BaseSumPairs {
        protected RangedSumPairs(int target) { super(target); }
        public Stream<IntTuple> find(int...source) {
            int max = Arrays.stream(source).max().getAsInt();
            int min = Arrays.stream(source).min().getAsInt();
            final int[] map = new int[max - min + 1];

            Arrays.stream(source).forEach(i -> map[i - min]++);

            return IntStream.range(min, max)
                    .filter(i -> target() - i - min >= 0 && map[target() - i - min] > 0)
                    .filter(i -> i < target() - i)
                    .mapToObj(i -> IntTuple.get(i, target() - i));
        }
    }

    public static void main(String...args) {
        int[] source = { 12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0 };
        int target = 7;
        String[] algorithms = { N2, NLOGN, N, RANGED };

        for (String a : algorithms) {
            System.out.printf("Implementation: %s\n", a);
            SumPairsFactory.getImplementation(a, target).find(source).forEach(System.out::print);
            System.out.println();
        }
    }
}
