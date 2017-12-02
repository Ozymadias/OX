package coregame;

class LanguageFileNotFoundException extends RuntimeException {
    LanguageFileNotFoundException(String language) {
        super("File with " + language + " not found!");
    }
}
