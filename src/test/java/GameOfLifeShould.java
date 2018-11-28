import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeShould {

    @ParameterizedTest
    @MethodSource("getParams")
    public void not_change_empty_board(int[][] input, int[][] expectedOutput) {
        GameOfLife game = new GameOfLife(input);
        assertThat(game.nextGen(), is(expectedOutput));
    }

    private static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(new int[][] { {0} }, new int[][] { {0} }),
                Arguments.of(new int[][] { {0,0}, {0,0} }, new int[][] { {0,0}, {0,0} })
        );
    }
}
