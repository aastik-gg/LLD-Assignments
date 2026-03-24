public class BallPen extends Pen {

    private static final RefillStrategy BALL_REFILL = new BallRefillStrategy();

    public BallPen(OpenCloseStrategy openCloseStrategy) {
        super(BALL_REFILL, openCloseStrategy);
    }
}