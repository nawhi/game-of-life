public class Cell {
    private boolean isAlive;

    Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public static final Cell ALIVE = new Cell(true);
    public static final Cell DEAD = new Cell(false);

    @Override
    public String toString() {
        return (isAlive ? "L" : "D");
    }
}
