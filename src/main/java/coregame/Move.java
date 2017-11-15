package coregame;

import endgame.Sign;

public class Move {
    private final Sign sign;
    private final Position position;

    public Move(Sign sign, Position position) {
        this.sign = sign;
        this.position = position;
    }
}
