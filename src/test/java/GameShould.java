import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameShould {

    @Test
    public void initialise_cells_to_dead() {
        Cell cell = new Game(3, 5).cellAt(2, 3);
        assertFalse(cell.isAlive());
    }

    @Test
    public void give_all_BorderCell_neighbours_to_single_cell() {
        Cell cell = new Game(1, 1).cellAt(0, 0);
        Cell neighbour = cell.getNeighbour(-1, -1);
        assertTrue(neighbour instanceof BorderCell);
    }

    @Test
    public void link_cell_neighbours_horizontally() {
        Game game = new Game(1, 2);
        Cell cell1 = game.cellAt(0, 0);
        Cell cell2 = game.cellAt(0, 1);
        assertSame(cell2, cell1.getNeighbour(0, 1));
        assertSame(cell1, cell2.getNeighbour(0, -1));
    }
}
