package coregame;

import com.google.common.collect.ImmutableMap;
import player.Player;

import java.util.HashMap;
import java.util.Map;

import static coregame.Result.*;

class Scoring {
    Map<Result, Integer> scoring = ImmutableMap.of(WIN, 3, DRAW, 1, LOSS, 0);
    Map<Player, Integer> playersScores = new HashMap<>();

    void register(Player player) {
        playersScores.put(player, 0);
    }

    void update(Player player, Result result) {
        int previousScore = playersScores.get(player);
        playersScores.put(player, previousScore + scoring.get(result));
    }

    int get(Player player) {
        return playersScores.get(player);
    }
}
