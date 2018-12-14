import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Game {

    private final Cell[][] cells;
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
        cells = new Cell[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                this.cells[i][j] = new GameCell(false);
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                cells[i][j].setNeighbours(neighboursForCell(i, j));
            }
        }
    }

    private List<Cell> neighboursForCell(int row, int col) {
        List<Cell> neighbours = new ArrayList<>();

        for (var coord: NEIGHBOUR_COORDS) {
            int neighbourRow = row + coord.getLeft();
            int neighbourCol = col + coord.getRight();
            Cell neighbour = neighbourFor(neighbourRow, neighbourCol);
            neighbours.add(neighbour);
        }
        return neighbours;
    }

    private Cell neighbourFor(int row, int col) {
        return coordInBounds(row, col) ? new BorderCell() : cells[row][col];
    }

    private boolean coordInBounds(int row, int col) {
        return row < 0 || row >= numRows
            || col < 0 || col >= numColumns;
    }

    public Cell cellAt(int row, int col) {
        return cells[row][col];
    }
}
