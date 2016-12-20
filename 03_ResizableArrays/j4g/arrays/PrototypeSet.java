package j4g.arrays;

public class PrototypeSet extends BaseArraySet {

    public PrototypeSet(int[] array, double factor) {
        super(array, factor);
    }

    public PrototypeSet(ResizableCollection<Integer> rc, double factor) {
        super(rc, factor);
    }

    /** {@inheritDoc} */
    @Override
    public Set intersection(int[] array) {
        int i = 0, j = 0;
        ResizableCollection<Integer> empty = new ResizableCollection<>();

        while (i < array.length && j < this.inner.size()) {
            if (array[i] < this.inner.get(j)) i++;
            else if (array[i] > this.inner.get(j)) j++;
            else { empty.add(array[i]); i++; j++; }
        }

        return new PrototypeSet(empty, this.loadFactor);
    }

    /** {@inheritDoc} */
    @Override
    public Set union(int[] array) {
        int i = 0, j = 0;
        ResizableCollection<Integer> empty = new ResizableCollection<>();

        while (i < array.length && j < this.inner.size()) {
            if (array[i] < this.inner.get(j)) { empty.add(array[i]; i++; }
            else if (array[i] > this.inner.get(j)) { empty.add(this.inner.get(j); j++; }
            else if (this.inner.size() > 0 && this.inner.get(this.inner.size() - 1) != array[i]) {
                empty.add(array[i]); i++; j++;
            }
        }

        return new PrototypeSet(empty, this.loadFactor);
    }
}
