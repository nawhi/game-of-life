import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameShould {

    @ParameterizedTest
    @MethodSource("getParams")
    public void not_change_empty_board(Cells input, Cells expectedOutput) {
        Game game = new Game(input);
        assertThat(game.nextGen(), is(expectedOutput));
    }

    private static Stream<Arguments> getParams() {
        return Stream.of(
            // TODO
        );
    }
}
