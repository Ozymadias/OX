import java.util.Optional;

public class Judge {
    private int winningNumber;
    private Board board;

    public Judge(int winningNumber, Board board) {
        this.winningNumber = winningNumber;
        this.board = board;
    }

    Optional<Sign> getWinner() {
        if (board.getCurrentPosition() == null)
            return Optional.empty();
        Sign currentSign = board.getCurrentSign();
        if (checkIfRowContainsOnlySameSigns(board.getCurrentPosition().getRowNb()))
            return Optional.of(currentSign);
        if (checkIfColumnContainsOnlySameSigns(board.getCurrentPosition().getColumnNb()))
            return Optional.of(currentSign);
        return Optional.empty();
    }

    private boolean checkIfColumnContainsOnlySameSigns(int columnNumber) {
        int numberOfOccurrences = 1;
        Sign sign = board.getCurrentSign();
        int rowsNb = board.getNumberOfRows();
        int currentRow = board.getCurrentPosition().getRowNb();

        for (int i = currentRow - 1; i >= 0; i--) {
            if (board.get(i, columnNumber) == sign)
                numberOfOccurrences++;
            else
                break;
        }
        for (int i = currentRow + 1; i < rowsNb; i++) {
            if (board.get(i, columnNumber) == sign)
                numberOfOccurrences++;
            else
                break;
        }
        return numberOfOccurrences >= winningNumber;
    }

    private boolean checkIfRowContainsOnlySameSigns(int rowNumber) {
        int numberOfOccurrences = 1;
        Sign sign = board.getCurrentSign();
        int columnsNb = board.getNumberOfColumns();
        int currentColumn = board.getCurrentPosition().getColumnNb();

        for (int j = currentColumn - 1; j >= 0; j--) {
            if (board.get(rowNumber, j) == sign)
                numberOfOccurrences++;
            else
                break;
        }
        for (int j = currentColumn + 1; j < columnsNb; j++) {
            if (board.get(rowNumber, j) == sign)
                numberOfOccurrences++;
            else
                break;
        }
        return numberOfOccurrences >= winningNumber;
    }
}
