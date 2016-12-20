package j4g.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Ernesto_Espinosa on 12/19/2016.
 */
public abstract class BaseArraySet implements Set {

    protected ResizableCollection<Integer> inner;
    protected double loadFactor;

    public BaseArraySet(int[] array, double loadFactor) {
        this(new ResizableCollection<Integer>(
                Arrays.stream(array).boxed().collect(Collectors.toList()).toArray(new Integer[0]),
                loadFactor));
    }

    public BaseArraySet(ResizableCollection<Integer> rc, double loadFactor) {
        this.inner = rc;
        this.loadFactor = loadFactor;
    }
}
