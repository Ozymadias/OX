package coregame;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Position {
    private final int rowNb;
    private final int columnNb;

    public Position(int rowNb, int columnNb) {
        this.rowNb = rowNb;
        this.columnNb = columnNb;
    }

    public int getColumnNb() {
        return columnNb;
    }

    public int getRowNb() {
        return rowNb;
    }
}