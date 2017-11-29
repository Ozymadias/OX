package earlygame;

class Validator {
    boolean isValid(String s) {
        return s.matches("\\s*[1-9]\\d?\\s+[1-9]\\d?\\s*");
    }
}
