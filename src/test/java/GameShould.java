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
    public void not_change_many_dead_cells() {
        Cells deadCells = new Cells(3, 4);
        Game game = new Game(deadCells);
        assertEquals(deadCells, game.nextGen());
    }

    @Test
    public void kill_single_alive_cell() {
        Game game = new Game(ONE_ALIVE_CELL);
        assertEquals(ONE_DEAD_CELL, game.nextGen());
    }

    @Test
    public void kill_live_cell_with_one_neighbour() {
        /*
        L L
        D D
        D D
         */
        Cells twoLiveCells = new Cells(2, 3)
                .bringToLife(0, 0)
                .bringToLife(1, 0);
        Cells allDeadCells = new Cells(2, 3);
        assertEquals(allDeadCells, new Game(twoLiveCells).nextGen());
    }

    @Test
    public void keep_alive_cells_with_two_neighbours() {
        /*
        D L D D
        D L L D
        */
        Cells cells = new Cells(4, 2)
                .bringToLife(1, 0)
                .bringToLife(1, 1)
                .bringToLife(2, 1);

        Cells actualCells = new Game(cells).nextGen();
        System.out.println("asserting that " +actualCells + "equals" + cells);
        assertEquals(actualCells, cells);
    }
}
