package player;

public class IntValidator {
    public boolean isValid(String winningNb) {
        return winningNb.matches("\\s*\\d+\\s*");
    }
}
