import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public final class PenFactory {

    private static final Map<String, Supplier<OpenCloseStrategy>> OPENERS = new HashMap<>();
    private static final Map<String, Function<OpenCloseStrategy, Pen>> PEN_BUILDERS = new HashMap<>();

    static {
        OPENERS.put("click", ClickStrategy::new);
        OPENERS.put("cap", UncapStrategy::new);

        PEN_BUILDERS.put("ink", InkPen::new);
        PEN_BUILDERS.put("gel", GelPen::new);
        PEN_BUILDERS.put("ball", BallPen::new);
    }

    private PenFactory() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Pen createPen(String type, String openType) {
        OpenCloseStrategy openStrategy = resolveOpenStrategy(openType);
        Function<OpenCloseStrategy, Pen> builder = PEN_BUILDERS.get(normalize(type));

        if (builder == null) {
            throw new IllegalArgumentException("Invalid pen type: " + Objects.toString(type));
        }

        return builder.apply(openStrategy);
    }

    private static OpenCloseStrategy resolveOpenStrategy(String openType) {
        Supplier<OpenCloseStrategy> supplier = OPENERS.get(normalize(openType));
        return supplier != null ? supplier.get() : new UncapStrategy();
    }

    private static String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase();
    }
}