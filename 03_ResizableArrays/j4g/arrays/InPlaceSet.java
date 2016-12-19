package j4g.arrays;

/**
 * Created by Ernesto_Espinosa on 12/19/2016.
 */
public class InPlaceSet extends BaseArraySet {

    public InPlaceSet(int[] array, double loadFactor) {
        super(array, loadFactor);
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
