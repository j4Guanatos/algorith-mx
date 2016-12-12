package j4g.util;

/**
 * Created by Ernesto_Espinosa on 12/11/2016.
 */
public class SameTypeTuple<T>  {

    private Tuple<T, T> tuple;

    private SameTypeTuple(T a, T b) {
        tuple = Tuple.get(a, b);
    }

    public static <T> SameTypeTuple get(T a, T b) {
        return new SameTypeTuple(a, b);
    }

    public T left() {
        return this.tuple.left();
    }

    public T right() {
        return this.tuple.right();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SameTypeTuple tuple = (SameTypeTuple) o;

        return this.tuple.equals(tuple.tuple);
    }

    @Override
    public int hashCode() {
        return this.tuple.hashCode();
    }

    @Override
    public String toString() {
        return this.tuple.toString();
    }
}
