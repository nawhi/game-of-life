import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Cells {
    private final GameCell[][] cells;
    private final int numRows;
    private final int numColumns;

    private Cells(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        cells = new GameCell[numRows][numColumns];
        forEachCell((row, col) -> cells[row][col] = new GameCell(false));
    }

    static Cells create(int numRows, int numColumns) {
        Cells object = new Cells(numRows, numColumns);

        object.forEachCell((row, col) -> {
            List<Cell> neighbours = new ArrayList<>();
            neighbours.add(object.getCellOrBorder(row-1, col-1));
            neighbours.add(object.getCellOrBorder(row-1, col  ));
            neighbours.add(object.getCellOrBorder(row-1, col+1));
            neighbours.add(object.getCellOrBorder(row,   col+1));
            neighbours.add(object.getCellOrBorder(row+1, col+1));
            neighbours.add(object.getCellOrBorder(row+1, col  ));
            neighbours.add(object.getCellOrBorder(row+1, col-1));
            neighbours.add(object.getCellOrBorder(row+1, col-1));

            object.cells[row][col].setNeighbours(neighbours);
        });
        return object;
    }


    private Cell getCellOrBorder(Integer row, Integer col) {
        boolean outOfBounds = row < 0
                || row >= numRows
                || col < 0
                || col >= numColumns;
        if (outOfBounds)
            return new BorderCell();
        return cells[row][col];
    }

    Cells(Cells other) {
        this.numRows = other.numRows;
        this.numColumns = other.numColumns;
        this.cells = new GameCell[numRows][numColumns];

        forEachCell((row, col) ->
                cells[row][col] = new GameCell(other.cells[row][col]));
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

    void bringAllToLife() {
        forEachCell(this::bringToLife);
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
