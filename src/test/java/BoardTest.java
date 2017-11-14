import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class BoardTest {
    @Test
    public void newBoardHasNoWinner() {
        Board board = new Board(3, 3);
        Optional<Sign> winner = board.getWinner();
        assertEquals(winner, Optional.empty());
    }

    @Test
    public void ifBoardHasRowWithSameSignsThisSignShouldWin() {
        Board board = new Board(3, 3, 3);
        for(int i = 0; i < 3; i++)
            board.put(Sign.X, 0, i);
        Optional<Sign> winner = board.getWinner();
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifBoardHasColumnWithSameSignsThisSignShouldWin() {
        Board board = new Board(3, 3, 3);
        for(int i = 0; i < 3; i++)
            board.put(Sign.X, i, 0);
        Optional<Sign> winner = board.getWinner();
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifTwoSignsWinsGameTwoSignsInSameRowShouldWin() {
        Board board = new Board(3, 3, 2);
        for(int i = 0; i < 2; i++)
            board.put(Sign.X, 0, i);
        Optional<Sign> winner = board.getWinner();
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void shouldOverrideToString() {
        Board board = new Board(3, 3, 3);
        String stringValue = board.toString();
        assertEquals(stringValue, " | | \n_____\n | | \n_____\n | | \n");
    }
}
