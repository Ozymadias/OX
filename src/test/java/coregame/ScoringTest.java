package coregame;

import org.testng.Assert;
import org.testng.annotations.Test;
import player.LocalPlayer;
import player.Player;

import java.util.HashMap;
import java.util.Map;

import static coregame.Result.DRAW;
import static coregame.Result.LOSS;
import static coregame.Result.WIN;

public class ScoringTest {

    @Test
    public void inDefaultCaseAfterOneWinPlayerGotThreePoints() {
        //Given
        Player player = new LocalPlayer("name");
        Scoring scoring = new Scoring();
        scoring.register(player);

        //When
        GameResults gameResults = new GameResults();
        gameResults.put(player, Result.WIN);
        scoring.update(gameResults);

        //Then
        Assert.assertEquals(scoring.get(player), 3);
    }

    @Test
    public void afterOneWinPlayerGotChosenNumberPoints() {
        //Given
        Player player = new LocalPlayer("name");

        Map<Result, Integer> resultToScoring = new HashMap<>();
        int pointsForWin = 4;
        resultToScoring.put(WIN, pointsForWin);
        resultToScoring.put(DRAW, 2);
        resultToScoring.put(LOSS, 0);
        Scoring scoring = new Scoring(resultToScoring);
        scoring.register(player);

        //When
        GameResults gameResults = new GameResults();
        gameResults.put(player, Result.WIN);
        scoring.update(gameResults);

        //Then
        Assert.assertEquals(scoring.get(player), pointsForWin);
    }
}
