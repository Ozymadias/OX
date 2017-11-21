package player;

import coregame.Position;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserTest {

    @DataProvider
    public static Object[][] positionToParse() {
        return new Object[][]{
                {5, 4, "5  4\n"},
                {17, 9, "  17            9         \n"},
                {3, 11, "  3   11  \n"},
                {13, 55, "    13 55\n"}
        };
    }

    @Test(dataProvider = "positionToParse")
    public void shouldReturnPositionWhenGivenStringWithTwoIntegers(int i, int j, String s) {
        assertEquals(new Position(i, j), Parser.parse(s));
    }
}
