package player;

import coregame.Position;

public class Parser {
    public Position parse(String s) {
        String[] coordinates = s.split("\\s+");
        int size = coordinates.length;
        return new Position(Integer.parseInt(coordinates[size - 2]), Integer.parseInt(coordinates[size - 1]));
    }
}
