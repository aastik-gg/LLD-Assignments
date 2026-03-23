import java.util.List;

class GameFactory {
    private GameFactory() {
    }

    public static Game getGame(int n, int players, String difficulty) {
        Board board = new Board(n);
        board.initialize();

        PlayerFactory pf = new PlayerFactory();
        List<Player> roster = pf.createPlayers(players);
        Validator validator = selectValidator(difficulty);
        return new Game(board, roster, validator);
    }

    private static Validator selectValidator(String difficulty) {
        if (difficulty != null && difficulty.equalsIgnoreCase("easy")) {
            return new EasyValidator();
        }
        return new HardValidator();
    }
}