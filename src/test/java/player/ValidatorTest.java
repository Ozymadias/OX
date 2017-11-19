package player;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {
    @Test
    public void shouldReturnFalseWhenGivenString() {
        Validator validator = new Validator();
        assertFalse(validator.isValid("string"));
    }

    @Test
    public void shouldRetrunTrueWhenGivenTwoIntegers() {
        Validator validator = new Validator();
        assertTrue(validator.isValid("5  4\n"));
    }
}
