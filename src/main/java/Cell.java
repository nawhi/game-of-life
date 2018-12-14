import java.util.List;

public interface Cell {
    void kill();

    void bringToLife();

    boolean isAlive();

    Cell getNeighbour(int relativeRow, int relativeCol);

    void mark();

    void evolve();

    void setNeighbours(List<Cell> neighbours);
}
