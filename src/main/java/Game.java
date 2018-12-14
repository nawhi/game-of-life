import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Cell[][] cells;
    private int numRows;
    private int numColumns;

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
        neighbours.add(neighbourFor(row - 1, col - 1));
        neighbours.add(neighbourFor(row - 1, col));
        neighbours.add(neighbourFor(row - 1, col + 1));
        neighbours.add(neighbourFor(row,     col + 1));
        neighbours.add(neighbourFor(row + 1, col + 1));
        neighbours.add(neighbourFor(row + 1, col));
        neighbours.add(neighbourFor(row + 1, col - 1));
        neighbours.add(neighbourFor(row,     col - 1));

        return neighbours;

    }

    private Cell neighbourFor(int row, int col) {
        if ((row < 0 || row >= numRows)
            || (col < 0 || col >= numColumns)) {
            return new BorderCell();
        }
        return cells[row][col];
    }

    public Cell cellAt(int row, int col) {
        return cells[row][col];
    }
}
