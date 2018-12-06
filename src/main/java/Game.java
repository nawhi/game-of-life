public class Game {
    private Cells cells;

    public Game(Cells cells) {
        this.cells = cells;
    }

    public Cells nextGen() {
        cells.kill(0, 0);
        return cells;
    }

}
