import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        ExportRequest safeReq = requireRequest(req);
        String title = safe(safeReq.title);
        String body = safe(safeReq.body);
        if (body.length() > 20) {
            return invalid("PDF cannot handle content > 20 chars");
        }
        String fakePdf = "PDF(" + title + "):" + body;
        return ExportResult.ok("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}