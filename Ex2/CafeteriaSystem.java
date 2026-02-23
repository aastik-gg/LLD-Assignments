import java.util.List;

public class CafeteriaSystem {
    private final MenuCatalog catalog;
    private final PricingService pricing;
    private final InvoiceFormatter formatter;
    private final InvoiceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem() {
        this(new MenuCatalog(), new TaxRules(), new DiscountRules(), new InvoiceFormatter(), new FileStore());
    }

    public CafeteriaSystem(MenuCatalog catalog,
                           TaxPolicy taxPolicy,
                           DiscountPolicy discountPolicy,
                           InvoiceFormatter formatter,
                           InvoiceStore store) {
        this.catalog = catalog;
        this.pricing = new PricingService(catalog, taxPolicy, discountPolicy);
        this.formatter = formatter;
        this.store = store;
    }

    public void addToMenu(MenuItem item) { catalog.add(item); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        PricingResult priced = pricing.price(customerType, lines);
        String printable = formatter.format(invId, priced);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}