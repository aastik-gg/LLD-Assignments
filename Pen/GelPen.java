public class GelPen extends Pen {

    private static final RefillStrategy GEL_REFILL = new GelRefillStrategy();

    public GelPen(OpenCloseStrategy openCloseStrategy) {
        super(GEL_REFILL, openCloseStrategy);
    }
}