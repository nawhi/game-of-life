import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeShould {

    private GameOfLife game;

    @Test
    void not_change_dead_cell_with_no_neighbours() {
        game = new GameOfLife(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        game.nextGen();

        assertThat(game.cell(1, 1), is(0));
    }


    @Test
    void not_change_dead_cell_with_one_neighbour() {
        game = new GameOfLife(new int[][] {
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 0}
        });

        game.nextGen();

        assertThat(game.cell(1, 1), is(0));
    }

    @Test
    void not_change_dead_cell_with_two_neighbours() {
        game = new GameOfLife(new int[][] {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        });

        game.nextGen();

        assertThat(game.cell(1, 1), is(0));
    }

}
