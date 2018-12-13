import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

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

    @ParameterizedTest
    @CsvSource({
            "0,-1:-1",
    })
    public void assign_neighbours_from_a_list(int listIndex, String coordinates) {
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

        String[] coordsArray = coordinates.split(":");
        int row = Integer.parseInt(coordsArray[0]);
        int col = Integer.parseInt(coordsArray[1]);

        List<Cell> neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new Cell(false));
        }
        neighbours.get(listIndex).bringToLife();

        Cell cell = new Cell(false, neighbours);
        Cell neighbour = cell.getNeighbour(row, col);
        assertTrue(neighbour.isAlive());
    }
}
