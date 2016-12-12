package j4g;

import j4g.util.Tuple;

import java.util.Map;
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

    public Tuple using(int...array) {
        Map<Integer, Integer> hash;
        Map.Entry<Integer, Integer> sumEntry;

        hash = IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(i ->  array[i], Function.identity()));

        sumEntry = hash
            .entrySet()
            .stream()
            .filter(e -> hash.containsKey(target - e.getKey())).findFirst().get();

        return Tuple.get(sumEntry.getValue(), hash.get(target - sumEntry.getKey()));
    }

    public static void main(String[] args) {
        SumPairIndex finder = SumPairIndex.find(7);

        System.out.println(
                finder.using(12, 4, 2, 7, 9, 27, 1, 13, 8, 16, 5, 10));
        System.out.println(
                finder.using(2, 3, 4, 100));
    }
}
