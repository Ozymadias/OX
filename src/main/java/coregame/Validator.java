package coregame;

public class Validator {
    private final int columns;
    private final int rows;

    public Validator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean validate(Position position) {
        return validateRow(position.getRowNb()) && validateColumn(position.getColumnNb());
    }

    private boolean validateColumn(int column) {
        return column >= 0 && column < columns;
    }

    private boolean validateRow(int row) {
        return row >= 0 && row < rows;
    }
}
