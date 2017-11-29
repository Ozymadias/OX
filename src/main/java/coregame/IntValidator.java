package coregame;

class IntValidator {
    boolean isValid(String winningNb) {
        return winningNb.matches("\\s*[0-9][0-9]?\\s*");
    }
}
