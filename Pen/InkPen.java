public class InkPen extends Pen {

    private static final RefillStrategy INK_REFILL = new InkRefillStrategy();

    public InkPen(OpenCloseStrategy openCloseStrategy) {
        super(INK_REFILL, openCloseStrategy);
    }
}