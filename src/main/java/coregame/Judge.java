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
        if (winInRow() || winInColumn() || winInDiagonal())
            return Optional.of(board.getCurrentSign());
        return Optional.empty();
    }

    private boolean winInRow() {
        int occurrences = nextOccurrences(board.horizontalIterator())
                + 1
                + previousOccurrences(board.horizontalIterator());

        return occurrences >= winningNumber;
    }

    private boolean winInColumn() {
        int occurrences = nextOccurrences(board.verticalIterator())
                + 1
                + previousOccurrences(board.verticalIterator());

        return occurrences >= winningNumber;
    }

    private boolean winInDiagonal() {
        int occurrences = nextOccurrences(board.diagonalIterator())
                + 1
                + previousOccurrences(board.diagonalIterator());

        return occurrences >= winningNumber;
    }

    private int previousOccurrences(MyIterator<Sign> it) {
        int occurrences = 0;
        while (it.hasPrevious() && board.isCurrent(it.previous()))
            occurrences++;

        return occurrences;
    }

    private int nextOccurrences(MyIterator<Sign> it) {
        int occurrences = 0;
        while (it.hasNext() && board.isCurrent(it.next()))
            occurrences++;

        return occurrences;
    }
}
