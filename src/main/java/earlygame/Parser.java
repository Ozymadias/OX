package earlygame;

class Parser {
    static Coordinates parse(String s) {
        String[] coordinates = s.split("\\s+");
        int size = coordinates.length;
        return new Coordinates(Integer.parseInt(coordinates[size - 2]), Integer.parseInt(coordinates[size - 1]));
    }
}
