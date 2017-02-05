package j4g.util;

/**
 * Created by nacho on 01/02/17.
 */
public class IntTuple {

    public final int X;
    public final int Y;

    public IntTuple(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public static IntTuple get(int x, int y) {
        return new IntTuple(x, y);
    }

    @Override
    public boolean equals(Object o) {
        IntTuple tuple;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        tuple = (IntTuple) o;
        return Integer.compare(this.X, tuple.X) == 0 && Integer.compare(this.Y, tuple.Y) == 0;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(X);
        result = 31 * result + Integer.hashCode(Y);
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", X, Y);
    }
}
