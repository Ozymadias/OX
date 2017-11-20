package player;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {
    @Test
    public void shouldReturnFalseWhenGivenString() {
        //Given
        Validator validator = new Validator();
        //When-Then
        assertFalse(validator.isValid("any string, it matters not what is here"));
    }

    @Test
    public void shouldReturnTrueWhenGivenTwoIntegers() {
        //Given
        Validator validator = new Validator();
        String digitSpaceOrMoreDigit = "5 4\n";
        //When-Then
        assertTrue(validator.isValid(digitSpaceOrMoreDigit));
    }
}
