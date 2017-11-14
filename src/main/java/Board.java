import java.util.Optional;

class Board {
    private Sign[][] board;
    private int numberOfRows;
    private int numberOfColumns;
    private int winningNumber;

    Board(int numberOfRows, int numberOfColumns, int winningNumber) {
        this.board = new Sign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.winningNumber = winningNumber;
    }

    Board(int numberOfRows, int numberOfColumns) {
        this.board = new Sign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    Optional<Sign> getWinner() {
        Optional<Sign> sign1 = checkRows();
        if (sign1.isPresent()) return sign1;
        Optional<Sign> sign = checkColumns();
        if (sign.isPresent()) return sign;
        return Optional.empty();
    }

    private Optional<Sign> checkRows() {
        for (int i = 0; i < numberOfRows; i++) {
            Optional<Sign> sign = checkIfRowContainsOnlySameSigns(i);
            if (sign.isPresent())
                return sign;
        }
        return Optional.empty();
    }

    private Optional<Sign> checkColumns() {
        for (int i = 0; i < numberOfColumns; i++) {
            Optional<Sign> sign = checkIfColumnContainsOnlySameSigns(i);
            if (sign.isPresent())
                return sign;
        }
        return Optional.empty();
    }

    private Optional<Sign> checkIfColumnContainsOnlySameSigns(int columnNumber) {
        int numberOfOccurrence = 0;
        Sign sign = null;
        for (int i = 0; i < numberOfRows; i++) {
            if (board[i][columnNumber] == sign) {
                numberOfOccurrence++;
                if (numberOfOccurrence == winningNumber && sign != null)
                    return Optional.of(sign);
            } else {
                sign = board[i][columnNumber];
                numberOfOccurrence = 1;
            }
        }
        return Optional.empty();
    }

    private Optional<Sign> checkIfRowContainsOnlySameSigns(int rowNumber) {
        int numberOfOccurrence = 0;
        Sign sign = null;
        for (int j = 0; j < numberOfColumns; j++) {
            if (board[rowNumber][j] == sign) {
                numberOfOccurrence++;
                if (numberOfOccurrence == winningNumber && sign != null)
                    return Optional.of(sign);
            } else {
                sign = board[rowNumber][j];
                numberOfOccurrence = 1;
            }
        }
        return Optional.empty();
    }

    void put(Sign sign, int rowNumber, int columnNumber) {
        board[rowNumber][columnNumber] = sign;
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
            if(i != numberOfRows - 1) {
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
    }
}
