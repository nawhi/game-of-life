import java.util.Arrays;
import java.util.function.BiConsumer;

public class Cells {
    private final Cell[][] cells;
    private final int numRows;
    private final int numColumns;

    Cells(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        cells = new Cell[numRows][numColumns];
        forEachCell((row, col) -> cells[row][col] = new Cell(false));
    }

    Cells(Cells other) {
        this.numRows = other.numRows;
        this.numColumns = other.numColumns;
        this.cells = new Cell[numRows][numColumns];

        forEachCell((row, col) ->
                cells[row][col] = new Cell(other.cells[row][col]));
    }

    private void forEachCell(BiConsumer<Integer, Integer> action) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                action.accept(row, col);
            }
        }
    }

    void killAll() {
        forEachCell(this::kill);
    }

    Cells kill(int row, int column) {
        cells[row][column].kill();
        return this;
    }

    Cell get(int row, int col) {
        return cells[row][col];
    }

    Cells bringToLife(int row, int col) {
        cells[row][col].bringToLife();
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
