package coregame;

import java.util.Optional;


class Judge {
    private int winningNumber;
    private Board board;

    Judge(int winningNumber, Board board) {
        this.winningNumber = winningNumber;
        this.board = board;
    }

    Optional<Sign> getWinner() {
        if (board.getCurrentPosition() == null)
            return Optional.empty();
        Sign currentSign = board.getCurrentSign();
        if (checkIfRowContainsOnlySameSigns2())
            return Optional.of(currentSign);
        if (checkIfColumnContainsOnlySameSigns2())
            return Optional.of(currentSign);
        return Optional.empty();
    }

    private boolean checkIfColumnContainsOnlySameSigns(int columnNumber) {
        int numberOfOccurrences = 1;
        Sign sign = board.getCurrentSign();
        int rowsNb = board.getNumberOfRows();
        int currentRow = board.getCurrentPosition().getRowNb();

        int i = currentRow - 1;
        while (board.get(i, columnNumber) == sign) {
            numberOfOccurrences++;
            i--;
        }
        for (int j = currentRow + 1; j < rowsNb; j++) {
            if (board.get(j, columnNumber) == sign)
                numberOfOccurrences++;
            else
                break;
        }
        return numberOfOccurrences >= winningNumber;
    }

    private boolean checkIfRowContainsOnlySameSigns2() {
        int numberOfOccurrences = -1;
        Sign sign = board.getCurrentSign();
        MyIterator<Sign> it = board.horizontalIterator();

        while (it.hasNext() && sign == it.next()) {
            numberOfOccurrences++;
        }
        it = board.horizontalIterator();
        while (it.hasPrevious() && sign == it.previous()) {
            numberOfOccurrences++;
        }
        return numberOfOccurrences >= winningNumber;
    }

    private boolean checkIfColumnContainsOnlySameSigns2() {
        int numberOfOccurrences = -1;
        Sign sign = board.getCurrentSign();
        MyIterator<Sign> it = board.verticalIterator();

        while (it.hasNext() && sign == it.next()) {
            numberOfOccurrences++;
        }
        it = board.horizontalIterator();
        while (it.hasPrevious() && sign == it.previous()) {
            numberOfOccurrences++;
        }
        return numberOfOccurrences >= winningNumber;
    }
}
