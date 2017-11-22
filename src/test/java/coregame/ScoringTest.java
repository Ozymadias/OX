package coregame;

import org.testng.Assert;
import org.testng.annotations.Test;
import player.LocalPlayer;
import player.Player;

public class ScoringTest {

    @Test
    public void testName() {
        //Given
        Player player = new LocalPlayer("name");
        Scoring scoring = new Scoring();
        scoring.register(player);

        //When
        scoring.update(player, Result.WIN);

        //Then
        Assert.assertEquals(scoring.get(player), 3);
    }
}
