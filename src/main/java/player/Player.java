package player;

import coregame.Position;

import java.util.Optional;

public interface Player {
    Optional<Position> makeMove();

    String getName();
}
