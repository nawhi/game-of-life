import java.util.Arrays;
import java.util.stream.IntStream;

public class Cells implements Cloneable {
    private final Cell[][] cells;
    private final int numRows;
    private final int numColumns;

    public Cells(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        cells = initialiseCells(numRows, numColumns);
    }

    public Cells(Cells other) {
        this.numRows = other.numRows;
        this.numColumns = other.numColumns;
        this.cells = new Cell[numRows][numColumns];

        IntStream.range(0, numRows).forEach(row -> {
            IntStream.range(0, numColumns).forEach(column -> {
                cells[row][column] = new Cell(other.cells[row][column]);
            });
        });
    }

    private Cell[][] initialiseCells(int numRows, int numColumns) {
        Cell[][] cells = new Cell[numRows][numColumns];
        IntStream.range(0, numRows).forEach(row -> {
            IntStream.range(0, numColumns).forEach(column -> {
                cells[row][column] = new Cell(false);
            });
        });
        return cells;
    }

    public Cells kill(int row, int column) {
        cells[row][column].kill();
        return this;
    }

    public void killAll() {
        IntStream.range(0, numRows).forEach(row -> {
            IntStream.range(0, numColumns).forEach(col -> {
                kill(row, col);
            });
        });
    }

    public Cell get(int row, int col) {
        return cells[row][col];
    }

    public Cells bringToLife(int row, int col) {
        cells[row][col].bringToLife();
        return this;
    }

    @Override
    public Cells clone() {
        Cells clone = new Cells(numRows, numColumns);
        IntStream.range(0, numColumns).forEach(row -> {
            clone.cells[row] = Arrays.copyOf(this.cells[row], this.numColumns);
        });
        return clone;
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
