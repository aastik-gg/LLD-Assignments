import java.util.List;

class Game {
    private final Board board;
    private final List<Player> players;
    private final Validator validator;

    public Game(Board board, List<Player> players, Validator validator) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("At least one player is required");
        }
        this.board = board;
        this.players = players;
        this.validator = validator;
    }

    public void start() {
        int turn = 0;
        boolean running = true;
        while (running) {
            Player current = players.get(turn % players.size());
            running = executeTurn(current);
            turn++;
        }
    }

    private boolean executeTurn(Player player) {
        System.out.println("\n" + player.getName() + "'s turn");
        int roll = board.roll();
        System.out.println(player.getName() + " rolled: " + roll);

        int tentative = player.getPosition() + roll;
        int validated = validator.adjustPosition(player, tentative, board.lastSquare());
        int finalPosition = board.resolveLanding(validated);
        player.moveTo(finalPosition);
        System.out.println(player.getName() + " at: " + finalPosition);

        if (finalPosition >= board.lastSquare()) {
            System.out.println(player.getName() + " wins!");
            return false;
        }
        return true;
    }
}