package player;

class IntParser {
    static int parse(String winningNb) {
        String[] coordinates = winningNb.split("\\s+");
        int size = coordinates.length;
        return Integer.parseInt(coordinates[size - 1]);
        //return winningNb.replaceAll("\\s+","").split("\\s+")[0];
    }
}
