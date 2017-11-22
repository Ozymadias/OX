package coregame;

public class NameValidator {
    public boolean validate(String s) {
        return s.matches("\\s*[a-zA-Z]+\\s*");
    }
}
