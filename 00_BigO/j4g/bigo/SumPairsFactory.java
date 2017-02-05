package j4g.bigo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Factory for algorithm implementations.
 */
public final class SumPairsFactory {

    // Avoid instantiability
    private SumPairsFactory() { throw new UnsupportedOperationException(); }
    private static final Map<String, Function<Integer, SumPairs>> providers = new ConcurrentHashMap<>();

    public static void register(String key, Function<Integer, SumPairs> algorithm) {
        providers.put(key, algorithm);
    }

    public static SumPairs getImplementation(String name, int target) {
        if (!providers.containsKey(name)) throw new IllegalArgumentException();
        return providers.get(name).apply(target);
    }
}
