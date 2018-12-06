import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {

    private final Cells ONE_DEAD_CELL = new Cells(1, 1);
    private final Cells ONE_ALIVE_CELL = new Cells(1, 1).bringToLife(0, 0);

    @Test
    public void not_change_single_dead_cell() {
        Game game = new Game(ONE_DEAD_CELL);
        assertEquals(ONE_DEAD_CELL, game.nextGen());
    }

    @Test
    public void kill_single_alive_cell() {
        Game game = new Game(ONE_ALIVE_CELL);
        assertEquals(ONE_DEAD_CELL, game.nextGen());
    }
}
