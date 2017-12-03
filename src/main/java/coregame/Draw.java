package coregame;

import player.Player;

import static coregame.Result.*;

class Draw implements GameResults {
    @Override
    public Result get(Player player) {
        return DRAW;
    }
}
