package coregame;

import player.Player;

import java.util.HashMap;
import java.util.Map;

import static coregame.Result.*;

class Scoring {
    Map<Result, Integer> resultToScoring = new HashMap<>();
    Map<Player, Integer> playersScores = new HashMap<>();

    Scoring(Map<Result, Integer> resultToScoring) {
        this.resultToScoring = resultToScoring;
    }

    Scoring() {
        resultToScoring.put(WIN, 3);
        resultToScoring.put(DRAW, 1);
        resultToScoring.put(LOSS, 0);
    }

    void register(Player player) {
        playersScores.put(player, 0);
    }

    void update(Player player, Result result) {
        int previousScore = playersScores.get(player);
        playersScores.put(player, previousScore + resultToScoring.get(result));
    }

    int get(Player player) {
        return playersScores.getOrDefault(player, 0);
    }

    void update(GameResults gameResults) {
        for (Player player:playersScores.keySet()) {
            int previousScore = playersScores.getOrDefault(player, 0);
            int newScore = resultToScoring.get(gameResults.get(player));
            playersScores.put(player, previousScore + newScore);
        }
    }
}
