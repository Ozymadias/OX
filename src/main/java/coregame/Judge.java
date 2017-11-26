package coregame;

import java.util.Collection;
import java.util.Optional;


class Judge {
    private int winningNumber;
    private Board board;

    Judge(int winningNumber, Board board) {
        this.winningNumber = winningNumber;
        this.board = board;
    }

    Optional<Sign> getWinner() {
        Collection<MyIterator<Sign>> iterators = board.createIterators();
        for (MyIterator<Sign> iterator : iterators)
            if (win(iterator))
                return Optional.of(board.getCurrentSign());

        return Optional.empty();
    }

    private boolean win(MyIterator<Sign> iterator) {
        int occurrences = nextOccurrences(iterator) + 1;
        iterator.reset();
        occurrences += previousOccurrences(iterator);

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
