import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeShould {

    private GameOfLife game;
    public static final int[][] DEAD_SINGLE_CELL = new int[][]{{0}};
    public static final int[][] ALIVE_SINGLE_CELL = new int[][]{{1}};

    @BeforeEach
    void setUp() {
        game = new GameOfLife();
    }

    @Test
    void not_change_empty_board_size_one() {
        assertThat(game.nextGen(DEAD_SINGLE_CELL), is(DEAD_SINGLE_CELL));
    }

    @Test
    void kill_single_cell_size_one() {
        assertThat(game.nextGen(ALIVE_SINGLE_CELL), CoreMatchers.is(DEAD_SINGLE_CELL));
    }

}
