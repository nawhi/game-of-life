import java.util.List;

public interface Cell {

    void setAlive();

    boolean isAlive();

    Cell neighbour(int relativeRow, int relativeCol);

    void mark();

    void evolve();

    void setNeighbours(List<Cell> neighbours);
}
