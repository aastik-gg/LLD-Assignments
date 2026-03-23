class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void moveTo(int target) {
        this.position = target;
    }
}