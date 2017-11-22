package coregame;

import player.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Game {
    private final Output output;
    private Player first;
    private Player second;
    private Judge judge;
    private Board board;
    private Player current;
    private Map<Player, Sign> playerSign;
    private Validator validator;

    Game(Player first, Player second) {
        this.first = first;
        this.second = second;
        output = new Output();
    }

    GameResults play() {
        playerSign = new HashMap<>();
        playerSign.put(first, Sign.X);
        playerSign.put(second, Sign.O);
        current = first;

        createBoard();

        Optional<Sign> winner = Optional.empty();

        while (!winner.isPresent() && !board.isFull()) {
            makeMove();
            winner = judge.getWinner();
            changePlayer();
        }

        changePlayer();
        output.print(board.toString());

        GameResults gameResult = new GameResults();
        if (board.isFull()) {
            output.print("remis");
            gameResult.put(first, Result.DRAW);
            gameResult.put(second, Result.DRAW);
        } else {
            output.print("zwyciezca jest " + current.getName());
            gameResult.put(current, Result.WIN);
            gameResult.put(notCurrent(), Result.LOSS);
        }
        return gameResult;
    }

    private Player notCurrent() {
        return current == first ? second : first;
    }

    private void makeMove() {
        output.print(board.toString());
        output.print("tura gracza: " + current.getName() + "(" + playerSign.get(current) + ")");
        output.print("podaj wpolrzedne pola w ktorym chcesz umiescic swoj znak w formacie \"rzad odstep kolumna\"");
        Position position = current.makeMove();
        while (!isPossible(position)) {
            output.print("podane dane przekraczaja zakres planszy lub powielaja wczesniejszy ruch, sprobuj ponownie");
            position = current.makeMove();
        }
        board.put(playerSign.get(current), position);
    }

    private boolean isPossible(Position position) {
        return validator.validate(position) && board.isTaken(position);
    }

    private void changePlayer() {
        current = current == first ? second : first;
    }

    private void createBoard() {
        output.print("podaj wymiary planszy w formacie \"rzedy odstep kolumny\"");

        Position size = first.decideBoardSize();
        int nbOfRows = size.getRowNb();
        int nbOfColumns = size.getColumnNb();

        while (nbOfColumns == 0 || nbOfRows == 0) {
            output.print("zero nie jest dopuszczalne jako wymiar, sprobuj jeszcze raz");
            size = first.decideBoardSize();
            nbOfRows = size.getRowNb();
            nbOfColumns = size.getColumnNb();
        }

        output.print("podaj liczbe znakow niezbedna do wygranej");
        int winningNb = current.provideWinningNumber();

        while ((winningNb > nbOfRows && winningNb > nbOfColumns) || winningNb == 0) {
            output.print("liczba niezbedna do wygranej musi byc mniejsza niz jeden z wymiarow planszy oraz wieksza od zera, sprobuj jeszcze raz");
            winningNb = current.provideWinningNumber();
        }

        board = new Board(nbOfRows, nbOfColumns);
        validator = new Validator(nbOfRows, nbOfColumns);
        judge = new Judge(winningNb, board);
    }
}
