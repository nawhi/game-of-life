import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeShould {

    private GameOfLife game;

    @Test
    void not_change_dead_cell_no_neighbours() {
        int[][] input = emptyBoard(3, 3);
        game = new GameOfLife(input);

        game.nextGen();

        assertThat(game.cell(1, 1), is(0));
    }

    public int[][] emptyBoard(int numberOfRows, int numberOfColumns) {
        return new int[numberOfRows][numberOfColumns];
    }

}
