import java.util.Map;
import java.util.Random;
import java.util.Set;

class Ladder {
    private static final int MAX_ATTEMPTS_FACTOR = 12;

    public static void generate(Map<Integer, Integer> ladders, int dimension, Set<Integer> blockedStarts) {
        ladders.clear();
        int maxCell = dimension * dimension;
        int target = dimension;
        Random random = new Random(19L * dimension);
        int attempts = 0;

        while (ladders.size() < target && attempts < target * MAX_ATTEMPTS_FACTOR) {
            int base = random.nextInt(maxCell - 1) + 1;
            if (blockedStarts.contains(base) || ladders.containsKey(base)) {
                attempts++;
                continue;
            }
            int climb = random.nextInt(maxCell - base) + 1;
            int top = base + climb;
            if (top <= base || top > maxCell) {
                attempts++;
                continue;
            }
            ladders.put(base, top);
        }

        if (ladders.size() < target) {
            fillSequentially(ladders, dimension, maxCell, target, blockedStarts);
        }
    }

    private static void fillSequentially(Map<Integer, Integer> ladders, int dimension, int maxCell, int target, Set<Integer> blockedStarts) {
        for (int base = 1; base < maxCell && ladders.size() < target; base++) {
            if (blockedStarts.contains(base) || ladders.containsKey(base)) {
                continue;
            }
            int top = Math.min(maxCell, base + dimension + ladders.size());
            if (top <= base) {
                continue;
            }
            ladders.put(base, top);
        }
    }
}