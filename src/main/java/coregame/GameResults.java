package coregame;

import player.Player;

import java.util.HashMap;
import java.util.Map;

class GameResults {
    private Map<Player, Result> playerResult = new HashMap<>();
    void put(Player player, Result result) {
        playerResult.put(player, result);
    }

    Result get(Player player) {
        return playerResult.get(player);
    }
}
