package player;

public class Validator {
    public boolean isValid(String s) {
        return s.matches("\\s*\\d+\\s+\\d+\\s*");
    }
}
