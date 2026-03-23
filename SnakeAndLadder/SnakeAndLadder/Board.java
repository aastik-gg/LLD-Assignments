import java.util.HashMap;
import java.util.Map;

class Board {
    private final int dimension;
    private final Map<Integer, Integer> snakes = new HashMap<>();
    private final Map<Integer, Integer> ladders = new HashMap<>();
    private final Dice dice = new Dice();

    public Board(int dimension) {
        if (dimension < 2) {
            throw new IllegalArgumentException("Board dimension must be at least 2");
        }
        this.dimension = dimension;
    }

    public void initialize() {
        snakes.clear();
        ladders.clear();
        Snakes.generate(snakes, dimension);
        Ladder.generate(ladders, dimension, snakes.keySet());
    }

    int lastSquare() {
        return dimension * dimension;
    }

    int roll() {
        return dice.roll();
    }

    int resolveLanding(int position) {
        Integer tail = snakes.get(position);
        if (tail != null) {
            System.out.println("Bitten by snake! Slide down to " + tail);
            return tail;
        }
        Integer top = ladders.get(position);
        if (top != null) {
            System.out.println("Climbed ladder! Move up to " + top);
            return top;
        }
        return position;
    }

}