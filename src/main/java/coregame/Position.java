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

    int getColumnNb() {
        return columnNb;
    }

    int getRowNb() {
        return rowNb;
    }
}