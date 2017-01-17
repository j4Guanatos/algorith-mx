package j4g.util;

import static j4g.util.Validator.require;

public class Pair<X,Y> {

    public final X x;
    public final Y y;

    public Pair(X a, Y b) {
        require(a,b);
        this.x = a;
        this.y = b;
    }

    @Override
    public boolean equals(Object o) {
        Pair tuple;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        tuple = (Pair) o;
        return x.equals(tuple.x) && y.equals(tuple.y);
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
