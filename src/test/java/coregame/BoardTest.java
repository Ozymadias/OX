package coregame;

import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class BoardTest {
    @Test
    public void newBoardHasNoWinner() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        //When
        Optional<Sign> winner = judge.getWinner();
        //Then
        assertEquals(winner, Optional.empty());
    }

    @Test
    public void ifBoardHasRowWithSameSignsThisSignShouldWin() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        //When
        for (int i = 0; i < 3; i++)
            board.put(Sign.X, 0, i);
        Optional<Sign> winner = judge.getWinner();
        //Then
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifBoardHasColumnWithSameSignsThisSignShouldWin() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        //When
        for (int i = 0; i < 3; i++)
            board.put(Sign.X, i, 0);
        Optional<Sign> winner = judge.getWinner();
        //Then
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifTwoSignsWinsGameTwoSignsInSameRowShouldWin() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(2, board);
        //When
        for (int i = 0; i < 2; i++)
            board.put(Sign.X, 0, i);
        Optional<Sign> winner = judge.getWinner();
        //Then
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void shouldOverrideToString() {
        //Given
        Board board = new Board(3, 3);
        //When
        String stringValue = board.toString();
        //Then
        assertEquals(stringValue, " | | \n_____\n | | \n_____\n | | \n");
    }
}
