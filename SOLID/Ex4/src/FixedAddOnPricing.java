package src;
public class FixedAddOnPricing implements AddOnPricing {
    private final AddOn addOn;
    private final Money fee;

    public FixedAddOnPricing(AddOn addOn, double feeAmount) {
        this.addOn = addOn;
        this.fee = new Money(feeAmount);
    }

    @Override
    public boolean supports(AddOn addOn) {
        return this.addOn == addOn;
    }

    @Override
    public Money price(AddOn addOn) {
        return fee;
    }
}
