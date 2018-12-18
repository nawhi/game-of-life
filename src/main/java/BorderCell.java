import java.util.List;

public class BorderCell implements Cell {

    @Override
    public void setAlive() {}

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public Cell neighbour(int relativeRow, int relativeCol) {
        return null;
    }

    @Override public void mark() {}
    @Override public void evolve() {}
    @Override public void setNeighbours(List<Cell> neighbours) {}
}
