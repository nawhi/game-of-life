import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameCell implements Cell {
    private boolean isAlive;
    private List<Cell> neighbours;

    GameCell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    GameCell(GameCell other) {
        this.isAlive = other.isAlive;
    }

    public GameCell(boolean isAlive, List<Cell> neighbours) {
        this.isAlive = isAlive;
        this.neighbours = neighbours;
    }

    @Override
    public void kill() {
        isAlive = false;
    }

    @Override
    public void bringToLife() {
        isAlive = true;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return (isAlive ? "L" : "D");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCell cell = (GameCell) o;
        return isAlive == cell.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }

    @Override
    public Cell getNeighbour(int row, int col) {
        int position = row + col + 2;
        int index = (row > col) ? (8 - position) : position;
        return neighbours.get(index);
    }

    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours = new ArrayList<>(neighbours);
    }
}
