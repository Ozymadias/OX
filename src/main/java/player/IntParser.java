package player;

public class IntParser {
    public int parse(String winningNb) {
        String[] coordinates = winningNb.split("\\s+");
        int size = coordinates.length;
        return Integer.parseInt(coordinates[size - 1]);
    }
}
