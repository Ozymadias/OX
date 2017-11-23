package earlygame;

import coregame.Position;

class Parser {
    static Position parse(String s) {
        String[] coordinates = s.split("\\s+");
        int size = coordinates.length;
        return new Position(Integer.parseInt(coordinates[size - 2]), Integer.parseInt(coordinates[size - 1]));
    }
}
