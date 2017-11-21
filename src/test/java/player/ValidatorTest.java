package player;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {
    private Validator validator = new Validator();;

    @DataProvider
    public static Object[][] acceptedStrings() {
        return new Object[][]{
                {"5 4\n"},
                {"  27            13         \n"},
                {"  7   14  \n"},
                {"    13 37\n"}
        };
    }

    @Test
    public void doesNotAcceptStrings() {
        assertFalse(validator.isValid("any string, it matters not what is here"));
    }

    @Test(dataProvider = "acceptedStrings")
    public void shouldReturnTrueWhenGivenTwoIntegers(String accepted) {
        assertTrue(validator.isValid(accepted));
    }
}
