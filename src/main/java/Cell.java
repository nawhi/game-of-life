import java.util.List;
import java.util.Objects;

public class Cell {
    private boolean isAlive;
    private List<Cell> neighbours;

    Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    Cell(Cell other) {
        this.isAlive = other.isAlive;
    }

    public Cell(boolean isAlive, List<Cell> neighbours) {
        this.isAlive = isAlive;
        this.neighbours = neighbours;
    }

    void kill() {
        isAlive = false;
    }

    void bringToLife() {
        isAlive = true;
    }

    boolean isAlive() {
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
        Cell cell = (Cell) o;
        return isAlive == cell.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }

    public Cell getNeighbour(int row, int col) {
        if (row > col)
            return neighbours.get(8 - (row+col+2));
        return neighbours.get(row + col + 2);
    }
}
