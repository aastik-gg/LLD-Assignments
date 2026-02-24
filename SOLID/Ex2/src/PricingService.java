package src;
import java.util.ArrayList;
import java.util.List;

public class PricingService {
    private final MenuCatalog catalog;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;

    public PricingService(MenuCatalog catalog, TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.catalog = catalog;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }

    public PricingResult price(String customerType, List<OrderLine> lines) {
        List<PricedLine> pricedLines = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine line : lines) {
            MenuItem item = catalog.require(line.itemId);
            double lineTotal = item.price * line.qty;
            pricedLines.add(new PricedLine(item.name, line.qty, lineTotal));
            subtotal += lineTotal;
        }

        double taxPercent = taxPolicy.percentFor(customerType);
        double taxAmount = subtotal * (taxPercent / 100.0);
        double discount = discountPolicy.discountFor(customerType, subtotal, lines.size());
        double total = subtotal + taxAmount - discount;

        return new PricingResult(pricedLines, subtotal, taxPercent, taxAmount, discount, total);
    }
}
