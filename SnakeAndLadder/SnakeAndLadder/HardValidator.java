class HardValidator implements Validator {
    @Override
    public int adjustPosition(Player player, int proposedPosition, int boardLimit) {
        if (proposedPosition > boardLimit) {
            System.out.println("Invalid move for " + player.getName() + ". Staying at " + player.getPosition());
            return player.getPosition();
        }
        return proposedPosition;
    }
}