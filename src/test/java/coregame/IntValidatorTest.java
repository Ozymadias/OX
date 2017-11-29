package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IntValidatorTest {
    private IntValidator intVal = new IntValidator();

    @DataProvider
    public static Object[][] notAcceptedStrings() {
        return new Object[][]{
                {"any string, it matters not what is here"},
                {"             13        3 \n"},
                {"2 4\n"},
                {"  something  4 \n"}
        };
    }

    @DataProvider
    public static Object[][] acceptedStrings() {
        return new Object[][]{
                {"5 \n"},
                {"             13         \n"},
                {"  24\n"},
                {"    41 \n"}
        };
    }

    @Test(dataProvider = "notAcceptedStrings")
    public void doesNotAcceptStrings(String notAccepted) {
        assertFalse(intVal.isValid(notAccepted));
    }

    @Test(dataProvider = "acceptedStrings")
    public void shouldReturnTrueWhenGivenTwoIntegers(String accepted) {
        assertTrue(intVal.isValid(accepted));
    }
}
