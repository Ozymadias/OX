package coregame;

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

    MyIterator<Sign> horizontalIterator() {
        return new HorizontalIterator();
    }

    MyIterator<Sign> verticalIterator() {
        return new VerticalIterator();
    }

    MyIterator<Sign> diagonalIterator() {
        return new DiagonalIterator();
    }

    MyIterator<Sign> antiDiagonalIterator() {
        return new AntiDiagonalIterator();
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
    }

    private class VerticalIterator implements MyIterator<Sign> {
        private int row;
        private int col;

        VerticalIterator() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }

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

    private class DiagonalIterator implements MyIterator<Sign> {
        private int row;
        private int col;

        DiagonalIterator() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }

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

    private class AntiDiagonalIterator implements MyIterator<Sign> {
        private int row;
        private int col;

        AntiDiagonalIterator() {
            this.row = Board.this.currentPosition.getRowNb();
            this.col = Board.this.currentPosition.getColumnNb();
        }

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
