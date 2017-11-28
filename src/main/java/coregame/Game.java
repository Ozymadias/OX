package coregame;

import earlygame.Coordinates;
import earlygame.Host;
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
        if (winner.isPresent()) {
            output.print("zwyciezca jest " + current.getName());
            gameResult.put(current, Result.WIN);
            gameResult.put(notCurrent(), Result.LOSS);
            return gameResult;
        }
        if (board.isFull()) {
            output.print("remis");
            gameResult.put(first, Result.DRAW);
            gameResult.put(second, Result.DRAW);
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
        output.print("podaj wymiary planszy w formacie \"rzedy odstep kolumny\" gdzie rzad i kolumna to liczby naturane wieksze od zera rozpoczynajace sie od cyfry roznej od zera");

        Host host = new Host();
        Coordinates size = host.decideBoardSize();
        int nbOfRows = size.getNumberOfRows();
        int nbOfColumns = size.getNumberOfColumns();

        output.print("podaj liczbe znakow niezbedna do wygranej");
        int winningNb = host.provideWinningNumber();

        while ((winningNb > nbOfRows && winningNb > nbOfColumns) || winningNb == 0) {
            output.print("liczba niezbedna do wygranej musi byc mniejsza niz jeden z wymiarow planszy oraz wieksza od zera, sprobuj jeszcze raz");
            winningNb = host.provideWinningNumber();
        }

        board = new Board(nbOfRows, nbOfColumns);
        validator = new Validator(nbOfRows, nbOfColumns);
        judge = new Judge(winningNb, board);
    }
}
