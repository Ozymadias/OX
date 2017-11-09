import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class BoardTest {
    @Test
    public void newBoardHasNoWinner() {
        Board board = new Board(3, 3);
        Optional<PlayerSign> winner = board.getWinner();
        assertEquals(winner, Optional.empty());
    }

    @Test
    public void ifBoardHasRowWithSameSignsThisSignShouldWin() {
        Board board = new Board(3, 3, 3);
        for(int i = 0; i < 3; i++)
            board.put(PlayerSign.X, 0, i);
        Optional<PlayerSign> winner = board.getWinner();
        assertEquals(winner, Optional.of(PlayerSign.X));
    }

    @Test
    public void ifBoardHasColumnWithSameSignsThisSignShouldWin() {
        Board board = new Board(3, 3, 3);
        for(int i = 0; i < 3; i++)
            board.put(PlayerSign.X, i, 0);
        Optional<PlayerSign> winner = board.getWinner();
        assertEquals(winner, Optional.of(PlayerSign.X));
    }

    @Test
    public void ifTwoSignsWinsGameTwoSignsInSameRowShouldWin() {
        Board board = new Board(3, 3, 2);
        for(int i = 0; i < 2; i++)
            board.put(PlayerSign.X, 0, i);
        Optional<PlayerSign> winner = board.getWinner();
        assertEquals(winner, Optional.of(PlayerSign.X));
    }
}
