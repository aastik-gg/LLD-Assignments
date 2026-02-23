/**
 * Base exporter contract: callers provide a non-null request; exporters return a non-null result
 * and never throw for valid input. Failures are reported via {@link ExportResult#error(String)}.
 */
public abstract class Exporter {
    protected final ExportResult invalid(String message) {
        return ExportResult.error(message);
    }

    protected final ExportRequest requireRequest(ExportRequest req) {
        if (req == null) throw new IllegalArgumentException("ExportRequest cannot be null");
        return req;
    }

    protected final String safe(String value) { return value == null ? "" : value; }

    public abstract ExportResult export(ExportRequest req);
}