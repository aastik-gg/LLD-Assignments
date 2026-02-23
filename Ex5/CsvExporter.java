import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        ExportRequest safeReq = requireRequest(req);
        String title = safe(safeReq.title);
        String body = safe(safeReq.body);
        String csv = buildCsv(title, body);
        return ExportResult.ok("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String buildCsv(String title, String body) {
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.append('\n');
        sb.append(ensureTrailingNewline(body));
        return sb.toString();
    }

    private String ensureTrailingNewline(String value) {
        return value.endsWith("\n") ? value : value + "\n";
    }
}