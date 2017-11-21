package player;

class IntValidator {
    boolean isValid(String winningNb) {
        return winningNb.matches("\\s*\\d+\\s*");
    }
}
