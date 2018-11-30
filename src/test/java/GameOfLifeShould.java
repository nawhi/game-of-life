import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeShould {
    @Test
    void not_change_empty_board_size_one() {
        GameOfLife game = new GameOfLife();
        int[][] cells = new int[][] { { 0 } };
        assertThat(game.nextGen(cells), is(cells));
    }

    @Test
    void not_change_empty_board_size_four() {
        GameOfLife game = new GameOfLife();
        int[][] cells = new int[][] {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
        };
        assertThat(game.nextGen(cells), is(cells));
    }

}
