import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellShould {

    @Test
    public void have_neighbours() {
        List<Cell> neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new Cell(false));
        }
        Cell cell = new Cell(false, neighbours);
    }

    @Test
    public void assign_neighbours_in_right_order() {
        /*
        list[0] = (-1,-1)
        list[1] = (-1, 0)
        list[2] = (-1, 1)
        list[3] =  (0, 1)
        list[4] =  (1, 1)
        list[5] =  (1, 0)
        list[6] =  (1,-1)
        list[7] =  (0,-1)
         */


        List<Cell> neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new Cell(false));
        }
        neighbours.get(0).bringToLife();

        assertTrue(new Cell(false, neighbours).getNeighbour(-1, -1).isAlive());
    }
}
