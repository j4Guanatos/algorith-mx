package j4g.util;

/**
 * Created by Ernesto_Espinosa on 12/11/2016.
 */
public class Tuple<L,R> {
    private L a;
    private R b;

    private Tuple(L a, R b) {
        this.a = a;
        this.b = b;
    }

    public L left() {
        return this.a;
    }

    public R right() {
        return this.b;
    }

    public static <L,R> Tuple get(L a, R b) {
        return new Tuple(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        return a.equals(tuple.a) && b.equals(tuple.b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", a, b);
    }
}
