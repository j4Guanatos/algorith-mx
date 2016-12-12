package j4g;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Consumer;

public class Finder {

    private int[] workingArray;
    private OptionalInt current = OptionalInt.empty();

    private Finder(int[] array) {
        this.workingArray = array;
    }

    /**
     * TODO: Force to be an unsorted array containing all numbers
     * between 1 and array.length except one (chosen arbitrarily).
     * @param arr Working array.
     * @return Finder instance.
     */
    public static Finder using(int...arr) {
        return new Finder(arr);
    }

    private int sumUpToN() {
        return ((workingArray.length + 1) * (workingArray.length + 2)) / 2;
    }

    public Finder missing() {
        current = OptionalInt.of(sumUpToN() - Arrays.stream(workingArray).sum());
        return this;
    }

    public Finder kthLeft(int k) {
        current = OptionalInt.of(Arrays.stream(workingArray).sorted().toArray()[k - 1]);
        return this;
    }

    public Finder kthRight(int k) {
        current = OptionalInt.of(Arrays.stream(workingArray).sorted().toArray()[workingArray.length - k]);
        return this;
    }

    public Finder to(Consumer<Integer> consumer) {
        consumer.accept(current.isPresent() ? current.getAsInt() : current.orElse(-1));
        return this;
    }

    public static void main(String[] args) {
        Finder.using(1, 2, 3, 4, 5, 6, 8, 9, 10)
                .missing().to(System.out::println)
                .kthLeft(2).to(System.out::println)
                .kthRight(3).to(System.out::println);
    }
}
