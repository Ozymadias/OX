package coregame;

import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class BoardTest {
    @Test
    public void boardWithOneMoveHasNoWinner() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        board.put(Sign.O, new Position(0, 0));
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
            board.put(Sign.X, new Position(0, i));
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
            board.put(Sign.X, new Position(i, 0));
        Optional<Sign> winner = judge.getWinner();
        //Then
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifBoardHasDiagonalWithSameSignsThisSignShouldWin() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        //When
        for (int i = 0; i < 3; i++)
            board.put(Sign.X, new Position(i, i));
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
            board.put(Sign.X, new Position(0, i));
        Optional<Sign> winner = judge.getWinner();
        //Then
        assertEquals(winner, Optional.of(Sign.X));
    }

    @Test
    public void ifBoardHasAntiDiagonalWithSameSignsThisSignShouldWin() {
        //Given
        Board board = new Board(3, 3);
        Judge judge = new Judge(3, board);
        //When
        for (int i = 0; i < 3; i++)
            board.put(Sign.X, new Position(i, 2 - i));
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
