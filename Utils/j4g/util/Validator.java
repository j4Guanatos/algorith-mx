package j4g.util;

/**
 * Created by Ernesto_Espinosa on 1/16/2017.
 */
public abstract class Validator {

    public static <T> void require(T...args) {
        for (T t : args) if (t == null) throw new IllegalArgumentException("Variables requires not be null");
    }
}
