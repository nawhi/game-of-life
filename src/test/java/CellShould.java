import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CellShould {

    @Test
    public void have_neighbours() {
        List<Cell> neighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            neighbours.add(new Cell(false));
        }
        Cell cell = new Cell(false, neighbours);
    }
}
