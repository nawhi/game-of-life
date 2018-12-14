import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameShould {

    @Test
    public void generate_cell_grid_with_given_dimensions() {
        new Game(1, 1);
    }

    @Test
    public void initialise_cells_to_dead() {
        Cell cell = new Game(1, 1).cellAt(0, 0);
        assertFalse(cell.isAlive());
    }
}
