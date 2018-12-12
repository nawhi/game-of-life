public class Game {
    private Cells cells;

    public Game(Cells cells) {
        this.cells = new Cells(cells);
    }

    public Cells nextGen() {
        cells.killAll();
        return cells();

    }

    private Cells cells() {
        return new Cells(cells);
    }
}
