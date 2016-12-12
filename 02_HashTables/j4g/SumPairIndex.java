package j4g;

import j4g.util.IntTuple;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Ernesto_Espinosa on 12/10/2016.
 */
public class SumPairIndex {

    private int target;

    private SumPairIndex(int target) {
        this.target = target;
    }

    public static SumPairIndex find(int target) {
        return new SumPairIndex(target);
    }

    public IntTuple using(int...array) {
        Map<Integer, Integer> hash;
        Map.Entry<Integer, Integer> sumEntry;

        hash = IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(i ->  array[i], Function.identity()));

        sumEntry = hash
            .entrySet()
            .stream()
            .filter(e -> hash.containsKey(target - e.getKey())).findFirst().get();

        return IntTuple.get(sumEntry.getValue(), hash.get(target - sumEntry.getKey()));
    }

    public class TestCase {
        int size;
        int firstPlaceholder = 0;
        int secondPlaceholder = 1;
        int targetDiff = 10;

        private TestCase(int size) {
            this.size = size;
        }

        public TestCase size(int size) {
            this.size = size;
            return this;
        }

        public TestCase targetDiff(int diff) {
            this.targetDiff = Math.max(10, diff);
            return this;
        }

        public TestCase firstPlaceholder(int i) {
            if (i == secondPlaceholder) throw new IllegalArgumentException();
            firstPlaceholder = i;
            return this;
        }

        public TestCase secondPlaceholder(int i) {
            if (i == firstPlaceholder) throw new IllegalArgumentException();
            secondPlaceholder = i;
            return this;
        }

        public int[] create() {
            List<Integer> randoms;

            randoms = IntStream.range(target + targetDiff, target + targetDiff + size)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(randoms);
            randoms.set(firstPlaceholder, 0);
            randoms.set(secondPlaceholder, target);

            return randoms.stream().mapToInt(i -> i).toArray();
        }
    }

    public TestCase testCaseFor(int size) {
        return new TestCase(size);
    }

    public static void main(String[] args) {
        SumPairIndex finder = SumPairIndex.find(7);
        TestCase testCase = finder.testCaseFor(10000).firstPlaceholder(55).secondPlaceholder(999);

        System.out.println(finder.using(12, 4, 2, 7, 9, 27, 1, 13, 8, 16, 5, 10));
        System.out.println(finder.using(2, 3, 4, 100));
        System.out.println(finder.using(testCase.create()));
    }
}
