package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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

    @DataProvider
    public static Object[][] negativeCoords() {
        return new Object[][]{
                {-4, 2},
                {3, -7},
                {-5, -1},
                {-2, 0}
        };
    }

    @DataProvider
    public static Object[][] greaterThanBoard() {
        return new Object[][]{
                {3, 3, 0, 3},
                {4, 3, 5, 1},
                {3, 4, 4, 2},
                {3, 19, 7, 0},
                {13, 13, 13, 14},
                {3, 3, 7, 8}
        };
    }

    @DataProvider
    public static Object[][] inside3x3Board() {
        return new Object[][]{
                {3, 3, 0, 0},
                {3, 3, 0, 1},
                {3, 3, 0, 2},
                {3, 3, 1, 0},
                {3, 3, 1, 1},
                {3, 3, 1, 2},
                {3, 3, 2, 0},
                {3, 3, 2, 1},
                {3, 3, 2, 2}
        };
    }

    @Test(dataProvider = "negativeCoords")
    public void cantHaveNegativeCoords(int row, int col) {
        Board board = new Board(3, 3);
        assertFalse(board.isValid(new Position(row, col)));
    }

    @Test(dataProvider = "greaterThanBoard")
    public void cantHaveCoordsGreaterThanBoardSize(int i, int j, int row, int col) {
        Board board = new Board(i, j);
        assertFalse(board.isValid(new Position(row, col)));
    }

    @Test(dataProvider = "inside3x3Board")
    public void acceptPosInsideBoard(int i, int j, int row, int col) {
        Board board = new Board(3, 3);
        assertTrue(board.isValid(new Position(row, col)));
    }
}
