import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CellsShould {
    @Test
    public void initialise_to_dead() {
        Cells cells = new Cells(5, 5);
        IntStream.range(0, 5).forEach(col -> {
            IntStream.range(0, 5).forEach(row -> {
                assertThat(cells.get(col, row), is(Cell.DEAD));
            });
        });
    }

    @Test
    public void be_settable_to_alive() {
        Cells cells = new Cells(3, 3);
        cells.bringToLife(1, 1);
        IntStream.range(0, 3).forEach(col -> {
            IntStream.range(0, 3).forEach(row -> {
                Cell cell = ((col == 1 && row == 1) ? Cell.ALIVE : Cell.DEAD);
                assertThat(cells.get(col, row), is(cell));
            });
        });
    }

    @Test
    public void be_settable_to_dead() {
        Cells cells = new Cells(1, 1)
                .bringToLife(0, 0)
                .kill(0, 0);
        assertThat(cells.get(0, 0), is(Cell.DEAD));

    }
}
