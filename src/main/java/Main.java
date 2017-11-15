import coregame.*;
import endgame.*;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

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
        JudgeLeaningTowardsOO ooJudge = new JudgeLeaningTowardsOO(new WinCondition(winningNb), new BoardOO());


        AllMoves allMoves = new AllMovesLinkedList();

        while (!winner.isPresent()) {
            output.print(board.toString());
            output.print("podaj lokacje do umieszczenia znaku");
            int x = input.getInt();
            int y = input.getInt();
            Position position = new Position(x, y);
            //if (currentSign.equals(Sign.X))
            //    ooJudge.updateXSequences(new XField());
            //else
            //    ooJudge.updateOSequences(new OField());
            board.put(currentSign, position);
            winner = judge.getWinner();
            currentSign = currentSign.change();

            Move move = new Move(currentSign, position);
            allMoves.add(move);
        }

        output.print(board.toString());
        output.print("zwyciezca jest " + winner.get());
    }
}
