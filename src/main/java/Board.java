import java.util.Optional;

class Board {
    private PlayerSign[][] board;
    private int numberOfRows;
    private int numberOfColumns;

    Board(int numberOfRows, int numberOfColumns) {
        this.board = new PlayerSign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    Optional<PlayerSign> getWinner() {
        for (int i = 0; i < numberOfRows; i++) {
            Optional<PlayerSign> sign = checkIfContainsOnlySameSigns(board[i]);
            if (sign.isPresent())
                return sign;
        }
        return Optional.empty();
    }

    private Optional<PlayerSign> checkIfContainsOnlySameSigns(PlayerSign[] row) {
        PlayerSign sign = row[0];
        if (sign == null)
            return Optional.empty();
        for (int j = 1; j < numberOfColumns; j++) {
            if (row[j] != sign)
                return Optional.empty();
        }
        return Optional.of(sign);
    }

    void put(PlayerSign playerSign, int rowNumber, int columnNumber) {
        board[rowNumber][columnNumber] = playerSign;
    }
}
