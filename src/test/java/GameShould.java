import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static junit.framework.TestCase.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameShould {

    @Test
    public void initialise_cells_to_dead() {
        Cell cell = new Game(3, 5).cellAt(2, 3);
        assertFalse(cell.isAlive());
    }

    @ParameterizedTest
    @CsvSource({
            "-1,-1",
            "-1,0",
            "-1,1",
            "0,1",
            "1,1",
            "1,0",
            "1,-1",
            "0,-1"
    })
    public void give_all_BorderCell_neighbours_to_single_cell(int row, int col) {
        Cell cell = new Game(1, 1).cellAt(0, 0);
        Cell neighbour = cell.neighbour(row, col);
        assertTrue(neighbour instanceof BorderCell);
    }

    @Test
    public void link_cell_neighbours_horizontally() {
        Game game = new Game(1, 2);
        Cell cell1 = game.cellAt(0, 0);
        Cell cell2 = game.cellAt(0, 1);
        assertSame(cell2, cell1.neighbour(0, 1));
        assertSame(cell1, cell2.neighbour(0, -1));
    }

    @Test
    public void link_cell_neighbours_vertically() {
        Game game = new Game(3, 2);
        Cell cell1 = game.cellAt(1, 1);
        Cell cell2 = game.cellAt(2, 1);
        assertSame(cell2, cell1.neighbour(1, 0));
        assertSame(cell1, cell2.neighbour(-1, 0));
    }

    @Test
    public void link_cell_neighbours_diagonally() {
        Game game = new Game(5, 5);
        Cell cell = game.cellAt(2, 2);

        assertSame(game.cellAt(1, 1), cell.neighbour(-1, -1));
        assertSame(game.cellAt(3, 3), cell.neighbour(1, 1));
        assertSame(game.cellAt(3, 1), cell.neighbour(1, -1));
        assertSame(game.cellAt(1, 3), cell.neighbour(-1, 1));
    }
}
