package coregame;

class IntValidator {
    boolean isValid(String winningNb) {
        return winningNb.matches("\\s*\\d+\\s*");
    }
}
