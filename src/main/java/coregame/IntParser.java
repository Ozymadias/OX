package coregame;

class IntParser {
    static int parse(String winningNb) {
        String[] coordinates = winningNb.split("\\s+");
        int size = coordinates.length;
        return Integer.parseInt(coordinates[size - 1]);
    }
}
