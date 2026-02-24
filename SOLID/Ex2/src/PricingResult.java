package src;
import java.util.List;

public class PricingResult {
    public final List<PricedLine> lines;
    public final double subtotal;
    public final double taxPercent;
    public final double taxAmount;
    public final double discount;
    public final double total;

    public PricingResult(List<PricedLine> lines,
                         double subtotal,
                         double taxPercent,
                         double taxAmount,
                         double discount,
                         double total) {
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxPercent = taxPercent;
        this.taxAmount = taxAmount;
        this.discount = discount;
        this.total = total;
    }
}
