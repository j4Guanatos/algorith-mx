package j4g.sorting;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem:
 *
 * Having a list of logs of stock values, perform efficiently the add and removal per client.
 *
 * Example:
 *
 * EPAM 0.9 >> Max for EPAM is 0.9
 * HEPAM 1.5 >> Max for HEPAM is 1.5
 * EPAM 1.1 >> Max for EPAM is 1.1
 * HEPAM 1.3 >> Max for HEPAM is 1.5
 * EPAM null >> Remove the last entry for EPAM, Max is now 0.9.
 * EPAM 0.8 >> Max for EPAM is 0.9
 * EPAM 1.3 >> Max for EPAM is 1.3
 *
 */
public class Logs {

    private Map<String, PriorityQueue<Double>> maxValues = new HashMap<>();
    private Map<String, Deque<Double>> valueStack = new HashMap<>();

    private static final Comparator<Double> reverseComparator = Comparator.reverseOrder();

    private void addIfAbsent(String company) {
        maxValues.putIfAbsent(company, new PriorityQueue<>(reverseComparator));
        valueStack.putIfAbsent(company, new ArrayDeque<>());
    }

    private void remove(String company) {
        maxValues.get(company).remove(valueStack.get(company).pop());
    }

    public double add(String company, Double value) {
        addIfAbsent(company);
        if (value == null) remove(company);
        else {
            valueStack.get(company).push(value);
            maxValues.get(company).add(value);
        }

        return maxValues.get(company).peek();
    }

    public static void main(String...args) {
        Logs logs = new Logs();
        String[] companies = { "EPAM", "IPAN", "EPAM", "IPAN", "EPAM", "EPAM", "EPAM" };
        Double[] values    = { 0.9   , 1.5   , 1.1   , 1.3   , null  , 0.8   , 1.3    };
        double[] expecteds = { 0.9   , 1.5   , 1.1   , 1.5   , 0.9   , 0.9   , 1.3    };

        IntStream.range(0, companies.length)
                .forEach(i -> System.out.printf("Max stock value for %s after adding %.2f is %.2f (expected: %.2f)\n",
                        companies[i], values[i], logs.add(companies[i], values[i]), expecteds[i]));
    }
}
