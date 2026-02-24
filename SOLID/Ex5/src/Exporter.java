package src;

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