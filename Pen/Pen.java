public abstract class Pen {

    private final RefillStrategy refillStrategy;
    private final OpenCloseStrategy openCloseStrategy;

    protected Pen(RefillStrategy refillStrategy, OpenCloseStrategy openCloseStrategy) {
        this.refillStrategy = refillStrategy;
        this.openCloseStrategy = openCloseStrategy;
    }

    public void start() {
        openCloseStrategy.open();
    }

    public void write(String message) {
        System.out.println(message);
    }

    public void close() {
        openCloseStrategy.close();
    }

    public void refill() {
        refillStrategy.refill();
    }
}