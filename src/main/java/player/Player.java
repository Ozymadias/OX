package player;

import coregame.Position;

public interface Player {
    Position makeMove();

    Position decideBoardSize();

    int provideWinningNumber();

    String getName();

    int getScore();

    void addPoint(int i);
}
