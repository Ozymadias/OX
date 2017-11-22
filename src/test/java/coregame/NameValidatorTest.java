package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NameValidatorTest {
    private NameValidator validator = new NameValidator();

    @DataProvider
    public static Object[] unproperNames() {
        return new Object[]{
                "",
                " ",
                "         ",
                "   ",
                " @> ,",
                "1name   ",
                "     2name",
                "some other name"
        };
    }

    @DataProvider
    public static Object[] properNames() {
        return new Object[]{
                "name",
                " ThirdName ",
                "       NAME     "
        };
    }

    @Test(dataProvider = "unproperNames")
    public void cantHaveNegativeCoords(String notAName) {
        assertFalse(validator.validate(notAName));
    }

    @Test(dataProvider = "properNames")
    public void cantHaveCoordsGreaterThanBoardSize(String name) {
        assertTrue(validator.validate(name));
    }
}
