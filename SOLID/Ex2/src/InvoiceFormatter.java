package src;
public class InvoiceFormatter {
    public String format(String invoiceId, PricingResult priced) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoiceId).append("\n");
        for (PricedLine line : priced.lines) {
            out.append(String.format("- %s x%d = %.2f\n", line.itemName, line.quantity, line.lineTotal));
        }
        out.append(String.format("Subtotal: %.2f\n", priced.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", priced.taxPercent, priced.taxAmount));
        out.append(String.format("Discount: -%.2f\n", priced.discount));
        out.append(String.format("TOTAL: %.2f\n", priced.total));
        return out.toString();
    }
}
