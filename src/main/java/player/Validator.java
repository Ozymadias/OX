package player;

class Validator {
    boolean isValid(String s) {
        return s.matches("\\s*\\d+\\s+\\d+\\s*");
    }
}
