public class PricedLine {
    public final String itemName;
    public final int quantity;
    public final double lineTotal;

    public PricedLine(String itemName, int quantity, double lineTotal) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
}
