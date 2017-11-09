import java.util.Optional;

class Board {
    private PlayerSign[][] board;
    private int numberOfRows;
    private int numberOfColumns;
    private int winningNumber;

    Board(int numberOfRows, int numberOfColumns, int winningNumber) {
        this.board = new PlayerSign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.winningNumber = winningNumber;
    }

    Board(int numberOfRows, int numberOfColumns) {
        this.board = new PlayerSign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    Optional<PlayerSign> getWinner() {
        Optional<PlayerSign> sign1 = checkRows();
        if (sign1.isPresent()) return sign1;
        Optional<PlayerSign> sign = checkColumns();
        if (sign.isPresent()) return sign;
        return Optional.empty();
    }

    private Optional<PlayerSign> checkRows() {
        for (int i = 0; i < numberOfRows; i++) {
            Optional<PlayerSign> sign = checkIfRowsContainsOnlySameSigns(i);
            if (sign.isPresent())
                return sign;
        }
        return Optional.empty();
    }

    private Optional<PlayerSign> checkColumns() {
        for (int i = 0; i < numberOfColumns; i++) {
            Optional<PlayerSign> sign = checkIfColumnsContainsOnlySameSigns(i);
            if (sign.isPresent())
                return sign;
        }
        return Optional.empty();
    }

    private Optional<PlayerSign> checkIfColumnsContainsOnlySameSigns(int columnNumber) {
        int numberOfOccurrence = 0;
        PlayerSign sign = null;
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

    private Optional<PlayerSign> checkIfRowsContainsOnlySameSigns(int rowNumber) {
        int numberOfOccurrence = 0;
        PlayerSign sign = null;
        for (int i = 0; i < numberOfRows; i++) {
            if (board[rowNumber][i] == sign) {
                numberOfOccurrence++;
                if (numberOfOccurrence == winningNumber && sign != null)
                    return Optional.of(sign);
            } else {
                sign = board[rowNumber][i];
                numberOfOccurrence = 1;
            }
        }
        return Optional.empty();
    }

    void put(PlayerSign playerSign, int rowNumber, int columnNumber) {
        board[rowNumber][columnNumber] = playerSign;
    }
}
