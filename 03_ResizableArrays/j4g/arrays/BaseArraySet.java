package j4g.arrays;

/**
 * Created by Ernesto_Espinosa on 12/19/2016.
 */
public abstract class BaseArraySet implements Set {

    protected int[] innerArray;
    protected int size;
    protected double loadFactor;

    public BaseArraySet(int[] array, double loadFactor) {
        this.innerArray = array;
        this.loadFactor = loadFactor;
    }

    protected void resize(int size) {
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = this.innerArray[i];
        }
        this.innerArray = newArray;
    }

}
