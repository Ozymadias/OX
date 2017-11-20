package player;

import coregame.Position;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserTest {
    @Test
    public void shouldReturnPositionWhenGivenStringWithTwoInteger() {
        //Given
        Parser parser = new Parser();
        //When-Then
        assertEquals(new Position(5, 4), parser.parse("5  4\n"));
    }
}
