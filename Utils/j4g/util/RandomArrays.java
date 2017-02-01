package j4g.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Random arrays generators.
 */
public interface RandomArrays {

    static int[] randomArray(int size, int min, int max) {
        return new Random().ints(size, min, max + 1).toArray();
    }

    public static void main(String...args) {
        System.out.println(Arrays.toString(randomArray(10,0,100)));
    }
}
