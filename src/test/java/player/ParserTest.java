package player;

import coregame.Position;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserTest {
    @Test
    public void shouldReturnPositionWhenGivenStringWithTwoInteger() {
        Parser parser = new Parser();
        Assert.assertEquals(new Position(5, 4), parser.parse("5  4\n"));
    }
}
