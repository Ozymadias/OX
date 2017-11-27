package coregame;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Board {
    private Sign[][] board;
    private int numberOfRows;
    private int numberOfColumns;
    private Position currentPosition;
    private Sign currentSign;
    private int moveCounter;

    Board(int numberOfRows, int numberOfColumns) {
        this.board = new Sign[numberOfRows][numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.moveCounter = numberOfColumns * numberOfRows;
    }

    Collection<MyIterator<Sign>> createIterators() {
        Collection<MyIterator<Sign>> iterators = new HashSet<>();
        iterators.add(new HorizontalIterator());
        iterators.add(new VerticalIterator());
        iterators.add(new DiagonalIterator());
        iterators.add(new AntiDiagonalIterator());
        return iterators;
    }

    void put(Sign sign, int rowNumber, int columnNumber) {
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

    void put(Sign sign, Position position) {
        board[position.getRowNb()][position.getColumnNb()] = sign;
        currentPosition = position;
        currentSign = sign;
        moveCounter--;
    }

    Sign getCurrentSign() {
        return currentSign;
    }

    boolean isTaken(Position position) {
        return board[position.getRowNb()][position.getColumnNb()] == null;
    }

    boolean isFull() {
        return moveCounter == 0;
    }

    boolean isCurrent(Sign sign) {
        return currentSign == sign;
    }

    private abstract class AbstractIterator implements MyIterator<Sign> {
        int row;
        int col;

        AbstractIterator() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }


        @Override
        public void reset() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }
    }

    private class HorizontalIterator extends AbstractIterator {

        @Override
        public boolean hasNext() {
            return col < Board.this.numberOfColumns - 1;
        }

        @Override
        public Sign next() {
            if (this.hasNext()) {
                col++;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return col > 0;
        }

        @Override
        public Sign previous() {
            if (this.hasPrevious()) {
                col--;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void reset() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }
    }

    private class VerticalIterator extends AbstractIterator {
        @Override
        public boolean hasNext() {
            return row < Board.this.numberOfRows - 1;
        }

        @Override
        public Sign next() {
            if (this.hasNext()) {
                row++;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return row > 0;
        }

        @Override
        public Sign previous() {
            if (this.hasPrevious()) {
                row--;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }
    }

    private class DiagonalIterator extends AbstractIterator {
        @Override
        public boolean hasNext() {
            return row < Board.this.numberOfRows - 1 && col < Board.this.numberOfColumns - 1;
        }

        @Override
        public Sign next() {
            if (this.hasNext()) {
                row++;
                col++;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return row > 0 && col > 0;
        }

        @Override
        public Sign previous() {
            if (this.hasPrevious()) {
                row--;
                col--;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }
    }

    private class AntiDiagonalIterator extends AbstractIterator {
        @Override
        public boolean hasNext() {
            return row > 0 && col < Board.this.numberOfColumns - 1;
        }

        @Override
        public Sign next() {
            if (this.hasNext()) {
                row--;
                col++;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return row < Board.this.numberOfRows - 1 && col > 0;
        }

        @Override
        public Sign previous() {
            if (this.hasPrevious()) {
                row++;
                col--;
                return Board.this.board[row][col];
            }
            throw new NoSuchElementException();
        }
    }
}
