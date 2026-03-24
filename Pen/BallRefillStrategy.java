public class BallRefillStrategy implements RefillStrategy {
    @Override
    public void refill() {
        System.out.println("Loading a fresh ballpoint refill...");
    }
}