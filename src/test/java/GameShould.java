import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {

    @Test
    public void not_change_empty_board() {
        Cells input = new Cells(1, 1);
        Game game = new Game(input);
        assertEquals(input, game.nextGen());
    }
}
