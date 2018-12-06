import java.util.stream.IntStream;

public class Game {
    private Cells cells;

    public Game(Cells cells) {
        this.cells = cells;
    }

    public Cells nextGen() {
        System.out.println("before, cells=" + cells);
        cells.killAll();
        System.out.println("after, cells=" + cells);
        return cells;

    }
}
