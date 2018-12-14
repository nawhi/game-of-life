import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeadGameCellShould {

    private List<Cell> neighbours;

    @BeforeEach
    void setUp() {
        neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new GameCell(false));
        }
    }

    @Test
    public void stay_dead_if_no_live_neighbours() {
        GameCell cell = deadCellWith(neighbours);
        assertFalse(cell.isAlive());
    }

    @Test
    public void stay_dead_if_one_live_neighbour() {
        neighbours.get(0).bringToLife();
        GameCell cell = deadCellWith(neighbours);
        assertFalse(cell.isAlive());
    }

    @Test
    public void stay_dead_if_two_live_neighbours() {
        neighbours.get(0).bringToLife();
        neighbours.get(1).bringToLife();
        GameCell cell = deadCellWith(neighbours);
        assertFalse(cell.isAlive());
    }

    @Test
    public void become_alive_if_exactly_three_live_neighbours() {
        range(0, 3).forEach(i -> neighbours.get(i).bringToLife());
        GameCell cell = deadCellWith(neighbours);
        assertTrue(cell.isAlive());
    }

    private static GameCell deadCellWith(List<Cell> neighbours) {
        GameCell cell = new GameCell(false, neighbours);
        cell.mark();
        cell.evolve();
        return cell;
    }
}
