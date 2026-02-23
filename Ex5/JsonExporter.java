import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        ExportRequest safeReq = requireRequest(req);
        String title = safe(safeReq.title);
        String body = safe(safeReq.body);
        String json = encode(title, body);
        return ExportResult.ok("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String encode(String title, String body) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("\"t\":\"").append(escape(title)).append("\",");
        sb.append("\"r\":[");
        String[] lines = splitBody(body);
        for (int i = 0; i < lines.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('"').append(escape(lines[i])).append('"');
        }
        sb.append(']');
        sb.append('}');
        return sb.toString();
    }

    private String[] splitBody(String body) {
        if (body.isEmpty()) return new String[0];
        String[] raw = body.split("\n", -1);
        int end = raw.length;
        while (end > 0 && raw[end - 1].isEmpty()) end--;
        if (end == raw.length) return raw;
        String[] trimmed = new String[end];
        System.arraycopy(raw, 0, trimmed, 0, end);
        return trimmed;
    }

    private String escape(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '"' -> sb.append("\\\"");
                case '\\' -> sb.append("\\\\");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }
}