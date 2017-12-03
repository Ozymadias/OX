package coregame;

import player.Player;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static coregame.Result.*;

class Scoring {
    private EnumMap<Result, Integer> resultToScoring = new EnumMap<>(Result.class);
    private Map<Player, Integer> playersScores = new HashMap<>();

    Scoring(EnumMap<Result, Integer> resultToScoring) {
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

    int get(Player player) {
        return playersScores.getOrDefault(player, 0);
    }

    void update(GameResults gameResults) {
        for (Player player : playersScores.keySet()) {
            int previousScore = playersScores.getOrDefault(player, 0);
            int newScore = resultToScoring.get(gameResults.get(player));
            playersScores.put(player, previousScore + newScore);
        }
    }
}
