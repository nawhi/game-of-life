import java.util.Arrays;
import java.util.stream.IntStream;

public class Cells {
    private final Cell[][] cells;
    private final int numRows;
    private final int numColumns;

    public Cells(int numColumns, int numRows) {
        this.numColumns = numColumns;
        this.numRows = numRows;

        cells = new Cell[numRows][numColumns];
        killAll();
    }

    public Cells kill(int column, int row) {
        cells[row][column] = Cell.DEAD;
        return this;
    }

    public void killAll() {
        IntStream.range(0, numColumns).forEach(col -> {
            IntStream.range(0, numRows).forEach(row -> {
                kill(col, row);
            });
        });
    }

    public Cell get(int column, int row) {
        return cells[row][column];
    }


    public Cells bringToLife(int column, int row) {
        cells[row][column] = Cell.ALIVE;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cells cells1 = (Cells) o;
        return Arrays.deepEquals(cells1.cells, cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cells);
    }
}
