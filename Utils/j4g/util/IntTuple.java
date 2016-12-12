package j4g.util;

/**
 * Created by Ernesto_Espinosa on 11/28/2016.
 */
public class IntTuple {
    private int a, b;

    private IntTuple(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int left() {
        return this.a;
    }

    public int right() {
        return this.b;
    }

    public static IntTuple get(int a, int b) {
        return new IntTuple(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntTuple intTuple = (IntTuple) o;

        if (a != intTuple.a) return false;
        return b == intTuple.b;

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", a, b);
    }
}
