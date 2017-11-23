package player;

import coregame.Position;

public interface Player {
    Position makeMove();

    String getName();
}
