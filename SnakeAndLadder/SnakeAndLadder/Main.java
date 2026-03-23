public class Main {
    public static void main(String[] args) {
        int dimension = args.length > 0 ? Integer.parseInt(args[0]) : 10;
        int players = args.length > 1 ? Integer.parseInt(args[1]) : 2;
        String difficulty = args.length > 2 ? args[2] : "hard";

        Game game = GameFactory.getGame(dimension, players, difficulty);
        game.start();
    }
}