package coregame;

import coregame.Board;
import coregame.Judge;
import coregame.Sign;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class BoardTest {
    @Test
    public void newBoardHasNoWinner() {
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        Optional<Sign> winner = judge.getWinner();
        assertEquals(winner, Optional.empty());
    }

    @Test
    public void ifBoardHasRowWithSameSignsThisSignShouldWin() {
        Board board = new Board(3, 3);
        for(int i = 0; i < 3; i++)
            board.put(Sign.X, 0, i);
        Judge judge = new Judge(3, board);
        Optional<Sign> winner = judge.getWinner();
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifBoardHasColumnWithSameSignsThisSignShouldWin() {
        Board board = new Board(3, 3);
        for(int i = 0; i < 3; i++)
            board.put(Sign.X, i, 0);
        Judge judge = new Judge(3, board);
        Optional<Sign> winner = judge.getWinner();
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifTwoSignsWinsGameTwoSignsInSameRowShouldWin() {
        Board board = new Board(3, 3);
        for(int i = 0; i < 2; i++)
            board.put(Sign.X, 0, i);
        Judge judge = new Judge(2, board);
        Optional<Sign> winner = judge.getWinner();
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void shouldOverrideToString() {
        Board board = new Board(3, 3);
        String stringValue = board.toString();
        assertEquals(stringValue, " | | \n_____\n | | \n_____\n | | \n");
    }
}
