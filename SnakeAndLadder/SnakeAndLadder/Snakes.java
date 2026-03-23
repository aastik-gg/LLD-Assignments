import java.util.Map;
import java.util.Random;

class Snakes {
    private static final int MAX_ATTEMPTS_FACTOR = 12;

    public static void generate(Map<Integer, Integer> snakes, int dimension) {
        snakes.clear();
        int maxCell = dimension * dimension;
        int target = dimension;
        Random random = new Random(37L * dimension);
        int attempts = 0;
        while (snakes.size() < target && attempts < target * MAX_ATTEMPTS_FACTOR) {
            int head = random.nextInt(maxCell - 1) + 2; // ensure head > 1
            int tail = random.nextInt(head - 1) + 1;
            if (head - tail < 2) {
                attempts++;
                continue;
            }
            if (snakes.containsKey(head)) {
                attempts++;
                continue;
            }
            snakes.put(head, tail);
        }

        if (snakes.size() < target) {
            fillSequentially(snakes, dimension, maxCell, target);
        }
    }

    private static void fillSequentially(Map<Integer, Integer> snakes, int dimension, int maxCell, int target) {
        for (int head = maxCell - 1; head > 1 && snakes.size() < target; head--) {
            if (snakes.containsKey(head)) {
                continue;
            }
            int drop = Math.max(2, dimension / 2 + snakes.size());
            int tail = head - drop;
            if (tail < 1) {
                tail = 1;
            }
            if (tail >= head) {
                tail = head - 1;
            }
            snakes.put(head, tail);
        }
    }
}