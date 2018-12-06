public class Cells {
    private final Cell[][] cells;

    public Cells(int numColumns, int numRows) {
        cells = new Cell[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                cells[i][j] = Cell.DEAD;
            }
        }
    }

    public Cell get(int column, int row) {
        return cells[row][column];
    }

    public void set(int column, int row, Cell cell) {
        cells[row][column] = cell;
    }
}
