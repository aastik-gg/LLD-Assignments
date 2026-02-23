public class TaxRules implements TaxPolicy {
    @Override
    public double percentFor(String customerType) {
        // still a simple rule set; the interface just makes it swappable later
        if ("student".equalsIgnoreCase(customerType)) return 5.0;
        if ("staff".equalsIgnoreCase(customerType)) return 2.0;
        return 8.0;
    }
}