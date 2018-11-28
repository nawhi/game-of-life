import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeShould {

    @Test
    public void not_change_single_dead_cell() {
        GameOfLife game = new GameOfLife(new int[][] { {0} });
        assertThat(game.nextGen(), is(new int[][] { {0} }));
    }
}
