package coregame;

import java.util.Iterator;
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

    int getNumberOfRows() {
        return numberOfRows;
    }

    int getNumberOfColumns() {
        return numberOfColumns;
    }

    Position getCurrentPosition() {
        return currentPosition;
    }

    Sign get(int i, int j) {
        if (0 <= i && i < numberOfRows && 0 <= j && j < numberOfColumns)
            return board[i][j];
        return null;
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

    MyIterator<Sign> horizontalIterator() {
        return new HorizontalIterator();
    }

    MyIterator<Sign> verticalIterator() {
        return new VerticalIterator();
    }

    private class HorizontalIterator implements MyIterator<Sign> {
        private int row;
        private int col;

        HorizontalIterator() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }

        @Override
        public boolean hasNext() {
            return col < Board.this.numberOfColumns;
        }

        @Override
        public Sign next() {
            if (this.hasNext()) {
                int currentCol = col;
                col = col + 1;
                return Board.this.board[row][currentCol];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return col >= 0;
        }

        @Override
        public Sign previous() {
            if (this.hasNext()) {
                int currentCol = col;
                col = col - 1;
                return Board.this.board[row][currentCol];
            }
            throw new NoSuchElementException();
        }
    }

    private class VerticalIterator implements Iterator<Sign>, MyIterator<Sign> {
        private int row;
        private int col;

        VerticalIterator() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }

        @Override
        public boolean hasNext() {
            return col < Board.this.numberOfColumns;
        }

        @Override
        public Sign next() {
            if (this.hasNext()) {
                int currentCol = col;
                col = col + 1;
                return Board.this.board[row][currentCol];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Sign previous() {
            return null;
        }
    }
}
