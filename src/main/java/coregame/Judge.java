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
        if (rowContainsOnlySameSigns() || columnContainsOnlySameSigns())
            return Optional.of(board.getCurrentSign());
        return Optional.empty();
    }

    private boolean rowContainsOnlySameSigns() {
        int occurrences = nextOccurrences(board.horizontalIterator())
                + 1
                + previousOccurrences(board.horizontalIterator());

        return occurrences >= winningNumber;
    }

    private boolean columnContainsOnlySameSigns() {
        int occurrences = nextOccurrences(board.verticalIterator())
                + 1
                + previousOccurrences(board.verticalIterator());

        return occurrences >= winningNumber;
    }

    private int previousOccurrences(MyIterator<Sign> it) {
        int occurrences = -1;
        while (it.hasPrevious() && board.isCurrent(it.previous()))
            occurrences++;

        return occurrences;
    }

    private int nextOccurrences(MyIterator<Sign> it) {
        int occurrences = -1;
        while (it.hasNext() && board.isCurrent(it.next()))
            occurrences++;

        return occurrences;
    }
}
