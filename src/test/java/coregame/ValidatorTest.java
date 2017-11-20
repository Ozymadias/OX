package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator = new Validator(3, 3);

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

    @Test
    public void cantHaveNegativeCoords() {
        assertFalse(validator.validate(new Position(-1, 2)));
    }

    @Test(dataProvider = "inside3x3Board")
    public void acceptPosInsideBoard(int i, int j, int row, int col) {
        assertTrue(validator.validate(new Position(row, col)));
    }
}
