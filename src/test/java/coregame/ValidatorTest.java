package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {

    private SizeValidator validator = new SizeValidator(3, 3);

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
        assertFalse(validator.validate(new Position(row, col)));
    }

    @Test(dataProvider = "greaterThanBoard")
    public void cantHaveCoordsGreaterThanBoardSize(int i, int j, int row, int col) {
        SizeValidator val = new SizeValidator(i, j);
        assertFalse(val.validate(new Position(row, col)));
    }

    @Test(dataProvider = "inside3x3Board")
    public void acceptPosInsideBoard(int i, int j, int row, int col) {
        assertTrue(validator.validate(new Position(row, col)));
    }
}
