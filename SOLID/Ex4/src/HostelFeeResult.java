package src;
public class HostelFeeResult {
    public final Money monthly;
    public final Money deposit;

    public HostelFeeResult(Money monthly, Money deposit) {
        this.monthly = monthly;
        this.deposit = deposit;
    }
}
