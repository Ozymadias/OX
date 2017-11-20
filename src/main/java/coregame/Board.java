package coregame;

public class Board {
    private Sign[][] board;
    private int numberOfRows;
    private int numberOfColumns;
    private Position currentPosition;
    private Sign currentSign;
    private int moveCounter;

    public Board(int numberOfRows, int numberOfColumns) {
        this.board = new Sign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.moveCounter = numberOfColumns * numberOfRows;
    }

    public void put(Sign sign, int rowNumber, int columnNumber) {
        board[rowNumber][columnNumber] = sign;
        currentPosition = new Position(rowNumber, columnNumber);
        currentSign = sign;
        moveCounter--;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                stringBuilder.append(board[i][j] != null ? board[i][j] : " ");
                if (j != numberOfColumns - 1) {
                    stringBuilder.append("|");
                }
            }
            stringBuilder.append("\n");
            if (i != numberOfRows - 1) {
                for (int j = 0; j < 2 * numberOfColumns - 1; j++) {
                    stringBuilder.append("_");
                }
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void put(Sign sign, Position position) {
        board[position.getRowNb()][position.getColumnNb()] = sign;
        currentPosition = position;
        currentSign = sign;
        moveCounter--;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Sign get(int i, int j) {
        if (0 <= i && i < numberOfRows && 0 <= j && j < numberOfColumns)
            return board[i][j];
        return null;
    }

    public Sign getCurrentSign() {
        return currentSign;
    }

    public boolean isTaken(Position position) {
        return board[position.getRowNb()][position.getColumnNb()] == null;
    }

    public boolean isFull() {
        return moveCounter == 0;
    }
}
