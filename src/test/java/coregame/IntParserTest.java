package coregame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntParserTest {
    @DataProvider
    public static Object[][] stringWithOneInteger() {
        return new Object[][]{
                {5, "5\n"},
                {17, "  17                  \n"},
                {11, "     11\n"},
                {42, "42               \n"}
        };
    }

    @Test(dataProvider = "stringWithOneInteger")
    public void shouldParseStringWithOneInteger(int i, String s) {
        assertEquals(i, IntParser.parse(s));
    }

}
