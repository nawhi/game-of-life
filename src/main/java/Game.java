import java.util.stream.IntStream;

public class Game {
    private Cells cells;

    public Game(Cells cells) {
        this.cells = cells;
    }

    public Cells nextGen() {
        cells.killAll();
        return cells;

    }
}
