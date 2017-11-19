package coregame;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Player first = new LocalPlayer();
        Player second = new LocalPlayer();

        output.print("Witaj w grze OX");

        output.print("podaj wymiary planszy");
        int nbOfRows = input.getInt();
        int nbOfColumns = input.getInt();

        output.print("podaj liczbe znakow niezbedna do wygranej");
        int winningNb = input.getInt();

        Board board = new Board(nbOfRows, nbOfColumns);
        Judge judge = new Judge(winningNb, board);

        Optional<Sign> winner = Optional.empty();

        Sign currentSign = Sign.X;

        while (!winner.isPresent()) {
            output.print(board.toString());
            output.print("podaj lokacje do umieszczenia znaku");
            Position position = first.makeMove();
            board.put(currentSign, position);
            winner = judge.getWinner();
            currentSign = currentSign.change();
        }

        output.print(board.toString());
        output.print("zwyciezca jest " + winner.get());
    }
}
