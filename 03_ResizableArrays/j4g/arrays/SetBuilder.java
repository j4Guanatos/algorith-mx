package j4g.arrays;

/**
 * Created by Ernesto_Espinosa on 12/19/2016.
 */
public class SetBuilder {

    enum Strategy {

        IN_PLACE() {

            @Override
            Set instance(int[] array) {
                return new InPlaceSet(array);
            }
        },
        PRODUCE_NEW() {

            @Override
            Set instance(int[] array) {
                return new PrototypeSet(array);
            }
        };

        abstract Set instance(int[] array);
    }

    private int[] array;
    private Strategy strategy;

    private SetBuilder(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public static SetBuilder with(int...array) {
        return new SetBuilder(array);
    }

    public SetBuilder useStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public Set build() {
        return this.strategy.instance(this.array);
    }
}
