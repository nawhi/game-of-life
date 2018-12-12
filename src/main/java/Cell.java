import java.util.Objects;

public class Cell {
    private boolean isAlive;

    Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    Cell(Cell other) {
        this.isAlive = other.isAlive;
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
}
