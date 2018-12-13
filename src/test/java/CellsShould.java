import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellsShould {
    @Test
    public void initialise_to_dead() {
        Cells cells = new Cells(5, 5);
        IntStream.range(0, 5).forEach(col -> {
            IntStream.range(0, 5).forEach(row -> {
                assertThat(cells.get(col, row).isAlive(), is(false));
            });
        });
    }

    @Test
    public void be_settable_to_alive() {
        Cells cells = new Cells(3, 3);
        cells.bringToLife(1, 2);
        IntStream.range(0, 3).forEach(col -> {
            IntStream.range(0, 3).forEach(row -> {
                assertThat(cells.get(col, row).isAlive(), is(col == 1 && row == 2));
            });
        });
    }

    @Test
    public void be_settable_to_dead() {
        Cells cells = new Cells(2, 6)
                .bringToLife(1, 4)
                .kill(1, 4);
        assertThat(cells.get(1, 4).isAlive(), is(false));
    }

    @Test
    public void produce_distinct_copies() {
        Cells cells1 = new Cells(2, 3).bringToLife(1, 2);
        Cells cells2 = new Cells(cells1);

        cells2.kill(1, 2);

        assertThat(cells1.get(1, 2).isAlive(), is(true));
        assertThat(cells2.get(1, 2).isAlive(), is(false));
    }

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
        Cells cells = new Cells(1, 1);
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
