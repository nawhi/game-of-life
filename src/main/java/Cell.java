public interface Cell {
    void kill();

    void bringToLife();

    boolean isAlive();

    Cell getNeighbour(int row, int col);
}
