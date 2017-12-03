package coregame;

import org.testng.Assert;
import org.testng.annotations.Test;
import player.LocalPlayer;
import player.Player;

import java.util.EnumMap;

import static coregame.Result.*;

public class ScoringTest {

    @Test
    public void inDefaultCaseAfterOneWinPlayerGotThreePoints() {
        //Given
        Input input = new Input();
        Player player = new LocalPlayer("name", input);
        Scoring scoring = new Scoring();
        scoring.register(player);

        //When
        Win win = new Win();
        win.put(player, Result.WIN);
        scoring.update(win);

        //Then
        Assert.assertEquals(scoring.get(player), 3);
    }

    @Test
    public void afterOneWinPlayerGotChosenNumberPoints() {
        //Given
        Input input = new Input();
        Player player = new LocalPlayer("name", input);

        EnumMap<Result, Integer> resultToScoring = new EnumMap<>(Result.class);
        int pointsForWin = 4;
        resultToScoring.put(WIN, pointsForWin);
        resultToScoring.put(DRAW, 2);
        resultToScoring.put(LOSS, 0);
        Scoring scoring = new Scoring(resultToScoring);
        scoring.register(player);

        //When
        Win win = new Win();
        win.put(player, Result.WIN);
        scoring.update(win);

        //Then
        Assert.assertEquals(scoring.get(player), pointsForWin);
    }
}
