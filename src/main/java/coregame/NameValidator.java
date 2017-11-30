package coregame;

class NameValidator {
    boolean validate(String s) {
        return s.matches("\\s*[a-zA-Z]+\\s*");
    }
}
