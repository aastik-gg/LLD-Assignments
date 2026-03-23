import java.util.ArrayList;
import java.util.List;

class PlayerFactory {
    public List<Player> createPlayers(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Player count must be positive");
        }
        List<Player> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(new Player("Player" + i));
        }
        return list;
    }
}