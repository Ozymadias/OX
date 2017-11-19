package player;

import coregame.Position;

public class Parser {
    public Position parse(String s) {
        String[] coordinates = s.split("\\s+");
        return new Position(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }
}
