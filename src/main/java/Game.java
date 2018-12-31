import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static java.util.Arrays.asList;

public class Game {

    private Cell[][] cells;
    private int numRows;
    private int numColumns;
    public static final List<Pair<Integer, Integer>> NEIGHBOUR_COORDS = asList(
            Pair.of(-1, -1),
            Pair.of(-1, 0),
            Pair.of(-1, 1),
            Pair.of(0, 1),
            Pair.of(1, 1),
            Pair.of(1, 0),
            Pair.of(1, -1),
            Pair.of(0, -1)
    );

    public Game(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;

        initialiseCells();
        connectNeighbours();
    }

    private void initialiseCells() {
        cells = new Cell[numRows][numColumns];
        forEachCell((row, col) -> cells[row][col] = new GameCell(false));
    }

    private void connectNeighbours() {
        forEachCell((row, col) -> {
            List<Cell> neighbours = neighboursForCell(row, col);
            Cell cell = cells[row][col];
            cell.setNeighbours(neighbours);
        });
    }

    private void forEachCell(BiConsumer<Integer, Integer> operation) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                operation.accept(row, col);
            }
        }
    }

    private List<Cell> neighboursForCell(int row, int col) {
        List<Cell> neighbours = new ArrayList<>();

        for (var coordinate: NEIGHBOUR_COORDS) {
            int neighbourRow = row + coordinate.getLeft();
            int neighbourCol = col + coordinate.getRight();
            Cell neighbour = neighbourFor(neighbourRow, neighbourCol);
            neighbours.add(neighbour);
        }
        return neighbours;
    }

    private Cell neighbourFor(int row, int col) {
        return coordinateInBounds(row, col)
                ? new BorderCell()
                : cells[row][col];
    }

    private boolean coordinateInBounds(int row, int col) {
        return row < 0 || row >= numRows
            || col < 0 || col >= numColumns;
    }

    public Cell cellAt(int row, int col) {
        return cells[row][col];
    }
}
