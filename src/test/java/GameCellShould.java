import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameCellShould {

    private List<Cell> neighbours;

    @BeforeEach
    void setUp() {
        neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new GameCell(false));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0,-1:-1",
            "1,-1:0",
            "2,-1:1",
            "3,0:1",
            "4,1:1",
            "5,1:0",
            "6,1:-1",
            "7,0:-1"
    })
    public void assign_neighbours_from_a_list(int listIndex, String coordinates) {

        String[] coordsArray = coordinates.split(":");
        int row = Integer.parseInt(coordsArray[0]);
        int col = Integer.parseInt(coordsArray[1]);

        neighbours.get(listIndex).bringToLife();

        Cell cell = new GameCell(false, neighbours);
        Cell neighbour = cell.getNeighbour(row, col);
        assertTrue(neighbour.isAlive());
    }

    @Test
    public void die_if_no_live_neighbours() {
        GameCell cell = new GameCell(true, neighbours);
        cell.mark();
        cell.evolve();
        assertFalse(cell.isAlive());
    }

    @Test
    public void die_if_one_live_neighbour() {
        neighbours.set(0, new GameCell(true));
        GameCell cell = new GameCell(true, neighbours);
        cell.mark();
        cell.evolve();
        assertFalse(cell.isAlive());
    }
}
