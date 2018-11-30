public class GameOfLife {

    private int[][] cells;

    public GameOfLife(int[][] input) {
        this.cells = input;
    }

    public void nextGen() {

    }

    public int cell(int row, int col) {
        return cells[row][col];
    }
}
