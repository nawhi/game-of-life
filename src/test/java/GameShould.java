import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameShould {

    @Test
    public void initialise_cells_to_dead() {
        Cell cell = new Game(3, 5).cellAt(2, 3);
        assertFalse(cell.isAlive());
    }
}
