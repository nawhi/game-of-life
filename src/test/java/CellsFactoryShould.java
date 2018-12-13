import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellsFactoryShould {

    public static final List<Pair<Integer, Integer>> COORDS = asList(
            Pair.of(-1, -1),
            Pair.of(-1, 0),
            Pair.of(-1, 1),
            Pair.of(0, 1),
            Pair.of(1, 1),
            Pair.of(1, 0),
            Pair.of(1, -1),
            Pair.of(0, -1)
    );

    @Test
    public void link_single_cell_to_border_cells() {
        Cells cells = CellsFactory.create(1, 1);
        Cell cell = cells.get(0, 0);
        for (var coord: COORDS) {
            Cell neighbour = cell.getNeighbour(coord.getLeft(), coord.getRight());
            assertTrue(isBorderCell(neighbour));
        }
    }

    private boolean isBorderCell(Cell neighbour) {
        neighbour.bringToLife();
        return !neighbour.isAlive();
    }
}
