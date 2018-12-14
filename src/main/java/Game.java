public class Game {

    private final Cell[][] cells;

    public Game(int numRows, int numColumns) {
        cells = new Cell[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                cells[i][j] = new GameCell(false);
            }
        }
    }

    public Cell cellAt(int row, int col) {
        return cells[row][col];
    }
}
