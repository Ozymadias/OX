package coregame;

import earlygame.Coordinates;
import earlygame.Host;
import player.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Game {
    private final Messenger messenger;
    private Player first;
    private Player second;
    private Judge judge;
    private Board board;
    private Player current;
    private Map<Player, Sign> playerSign;
    private SizeValidator validator;

    Game(Player first, Player second) {
        this.first = first;
        this.second = second;
        messenger = new Messenger();
    }

    GameResults play(Input input) {
        playerSign = new HashMap<>();
        playerSign.put(first, Sign.X);
        playerSign.put(second, Sign.O);
        current = first;

        createBoard(input);

        Optional<Sign> winner = Optional.empty();

        while (!winner.isPresent() && !board.isFull()) {
            makeMove();
            winner = judge.getWinner();
            changePlayer();
        }

        changePlayer();
        messenger.show(board);

        GameResults gameResult = new GameResults();
        if (winner.isPresent()) {
            messenger.announceWin(current.getName());
            gameResult.put(current, Result.WIN);
            gameResult.put(notCurrent(), Result.LOSS);
            return gameResult;
        }
        if (board.isFull()) {
            messenger.announceDraw();
            gameResult.put(first, Result.DRAW);
            gameResult.put(second, Result.DRAW);
        }
        return gameResult;
    }

    private Player notCurrent() {
        return current == first ? second : first;
    }

    private void makeMove() {
        messenger.show(board);
        messenger.turn(current.getName(), playerSign.get(current));
        messenger.askAboutPosition();
        Optional<Position> position = current.makeMove();
        while (position.isPresent() && !isPossible(position.get())) {
            messenger.positionOutOfBoardOrRepeated();
            position = current.makeMove();
        }
        if (!position.isPresent())
            switchPlayers();
        else
            board.put(playerSign.get(current), position.get());
    }

    private void switchPlayers() {
        playerSign.put(first, playerSign.get(first).change());
        playerSign.put(second, playerSign.get(second).change());
    }

    private boolean isPossible(Position position) {
        return validator.validate(position) && board.isTaken(position);
    }

    private void changePlayer() {
        current = current == first ? second : first;
    }

    private void createBoard(Input input) {
        messenger.askAboutBoardSize();

        Host host = new Host(input);
        Coordinates size = host.decideBoardSize();
        int nbOfRows = size.getNumberOfRows();
        int nbOfColumns = size.getNumberOfColumns();

        messenger.askWinningCondition();
        int winningNb = host.provideWinningNumber();

        while ((winningNb > nbOfRows && winningNb > nbOfColumns) || winningNb == 0) {
            messenger.wrongWinningCondition();
            winningNb = host.provideWinningNumber();
        }

        board = new Board(nbOfRows, nbOfColumns);
        validator = new SizeValidator(nbOfRows, nbOfColumns);
        judge = new Judge(winningNb, board);
    }
}
