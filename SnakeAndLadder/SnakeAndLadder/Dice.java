import java.util.Random;

class Dice {
    private static final int DEFAULT_SIDES = 6;
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(DEFAULT_SIDES) + 1;
    }
}