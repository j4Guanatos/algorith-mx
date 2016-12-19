package j4g.arrays;

/**
 * Created by Ernesto_Espinosa on 12/19/2016.
 */
public class PrototypeSet implements Set {

    private int[] array;

    public PrototypeSet(int[] array) {
        this.array = array;
    }

    /** {@inheritDoc} */
    @Override
    public Set intersection(int[] array) {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Set union(int[] array) {
        return null;
    }
}
