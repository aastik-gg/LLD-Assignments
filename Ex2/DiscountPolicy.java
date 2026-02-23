public interface DiscountPolicy {
    double discountFor(String customerType, double subtotal, int distinctLines);
}
