package coregame;

import coregame.Position;
import coregame.Validator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {

    private Validator validator = new Validator(3, 3);

    @Test
    public void shouldReturnFalseWhenGivenPositionWithNegativeCoordinate() {
        assertFalse(validator.validate(new Position(-1, 2)));
    }

    @Test
    public void shouldReturnTrueWhenGivenPositionInsideBoard() {
        assertTrue(validator.validate(new Position(0, 0)));
    }
}
