import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AliveGameCellShould {

    private List<Cell> neighbours;

    @BeforeEach
    void setUp() {
        neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new GameCell(false));
        }
    }

    @Test
    public void die_if_no_live_neighbours() {
        GameCell cell = liveCellWith(neighbours);
        assertFalse(cell.isAlive());
    }

    @Test
    public void die_if_one_live_neighbour() {
        neighbours.get(0).setAlive();
        GameCell cell = liveCellWith(neighbours);
        assertFalse(cell.isAlive());
    }

    @Test
    public void stay_alive_if_two_live_neighbours() {
        neighbours.get(0).setAlive();
        neighbours.get(1).setAlive();
        GameCell cell = liveCellWith(neighbours);
        assertTrue(cell.isAlive());
    }

    @Test
    public void stay_alive_if_three_live_neighbours() {
        range(0, 3).forEach(i -> neighbours.get(i).setAlive());
        GameCell cell = liveCellWith(neighbours);
        assertTrue(cell.isAlive());
    }

    @Test
    public void die_if_more_than_three_live_neighbours() {
        range(0, 4).forEach(i -> neighbours.get(i).setAlive());
        GameCell cell = liveCellWith(neighbours);
        assertFalse(cell.isAlive());
    }

    private static GameCell liveCellWith(List<Cell> neighbours) {
        GameCell cell = new GameCell(true, neighbours);
        cell.mark();
        cell.evolve();
        return cell;
    }
}
