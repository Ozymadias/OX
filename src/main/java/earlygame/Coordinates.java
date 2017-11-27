package earlygame;

public class Coordinates {
    private final int numberOfRows;
    private final int numberOfColumns;

    Coordinates(int x, int y) {
        this.numberOfRows = x;
        this.numberOfColumns = y;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }
}
