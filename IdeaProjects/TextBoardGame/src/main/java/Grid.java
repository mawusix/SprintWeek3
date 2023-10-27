public interface Grid {
    void setSize(int size);
    void placePlayer();
    void placeTreasure();
    void displayGrid();
    boolean isPlayerOnTreasure();
    void movePlayer(char direction);
    int calculateDistanceToTreasure();
    void placeMonster();
    boolean isPlayerCaughtByMonster();
}
