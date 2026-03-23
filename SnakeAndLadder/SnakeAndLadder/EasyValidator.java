class EasyValidator implements Validator {
    @Override
    public int adjustPosition(Player player, int proposedPosition, int boardLimit) {
        return proposedPosition;
    }
}