import java.util.List;
import java.util.Objects;

public class GameCell implements Cell {
    private boolean isAlive;
    private List<Cell> neighbours;

    private boolean shouldBeAliveInNextGen = false;

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
    public void setAlive() {
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
    public Cell neighbour(int relativeRow, int relativeCol) {
        int position = relativeRow + relativeCol + 2;
        int index = (relativeRow > relativeCol) ? (8 - position) : position;
        return neighbours.get(index);
    }

    @Override
    public void mark() {
        int neighbourCount = getNumLiveNeighbours();
        if (isAlive) {
            shouldBeAliveInNextGen = (neighbourCount > 1 && neighbourCount <= 3);
        } else {
            shouldBeAliveInNextGen = (neighbourCount == 3);
        }
    }

    private int getNumLiveNeighbours() {
        return (int) neighbours.stream()
                .filter(n -> n.isAlive())
                .count();
    }

    @Override
    public void evolve() {
        isAlive = shouldBeAliveInNextGen;
    }

    @Override
    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }
}
