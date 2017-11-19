package coregame;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Game {

    private final Input input;
    private final Output output;
    private final Player first;
    private final Player second;
    private Judge judge;
    private Board board;
    private Player current;
    private Map<Player, Sign> playerSign;

    public Game() {
        input = new Input();
        output = new Output();
        first = new LocalPlayer();
        second = new LocalPlayer();
        playerSign = new HashMap<>();
        playerSign.put(first, Sign.X);
        playerSign.put(second, Sign.O);
        current = first;
    }

    public void play() {
        createBoard();
        Optional<Sign> winner = Optional.empty();

        while (!winner.isPresent()) {
            output.print(board.toString());
            output.print("podaj lokacje do umieszczenia znaku");
            Position position = current.makeMove();
            board.put(playerSign.get(current), position);
            winner = judge.getWinner();
            changePlayer();
        }

        output.print(board.toString());
        output.print("zwyciezca jest " + winner.get());
    }

    private void changePlayer() {
        current = current == first ? second : first;
    }

    private void createBoard() {
        output.print("Witaj w grze OX");

        output.print("podaj wymiary planszy");
        int nbOfRows = input.getInt();
        int nbOfColumns = input.getInt();

        output.print("podaj liczbe znakow niezbedna do wygranej");
        int winningNb = input.getInt();

        board = new Board(nbOfRows, nbOfColumns);
        judge = new Judge(winningNb, board);
    }
}
