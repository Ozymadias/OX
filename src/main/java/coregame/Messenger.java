package coregame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Messenger {
    private static Map<String, String> messages;

    static void provide(String language) {
        String fileName = "./src/main/java/resources/" + language + ".properties";
        messages = new HashMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String[] columns = line.split(" = ");
                messages.put(columns[0], columns[1]);
            });
        } catch (IOException e) {
            throw new LanguageFileNotFoundException(language);
        }
    }

    void askAboutPosition() {
        Output.print(messages.get("askAboutPosition"));
    }

    void positionOutOfBoardOrRepeated() {
        Output.print(messages.get("positionOutOfBoardOrRepeated"));
    }

    void askAboutBoardSize() {
        Output.print(messages.get("askAboutBoardSize"));
    }

    void askWinningCondition() {
        Output.print(messages.get("askWinningCondition"));
    }

    void wrongWinningCondition() {
        Output.print(messages.get("wrongWinningCondition"));
    }

    void announceDraw() {
        Output.print(messages.get("announceDraw"));
    }

    public void repeat() {
        Output.print(messages.get("repeat"));
    }

    void settings() {
        Output.print(messages.get("settings"));
    }

    void decideNumberOfGamesInMatch() {
        Output.print(messages.get("decideNumberOfGamesInMatch"));
    }

    void gameOver() {
        Output.print("\n" + messages.get("gameOver"));
    }

    void chooseScoreForWin() {
        Output.print(messages.get("chooseScoreForWin"));
    }

    void chooseScoreForDraw() {
        Output.print(messages.get("chooseScoreForDraw"));
    }

    void chooseScoreForLost() {
        Output.print(messages.get("chooseScoreForLost"));
    }

    void askFirstName() {
        Output.print(messages.get("askFirstName"));
    }

    void askSecondName() {
        Output.print(messages.get("askSecondName"));
    }

    void wrongName() {
        Output.print(messages.get("wrongName"));
    }

    void announceWin(String name) {
        Output.print(messages.get("announceWin") + name);
    }

    void turn(String name, Sign sign) {
        Output.print(messages.get("turn") + name + "(" + sign + ")");
    }

    void printResults(String score1, String score2) {
        Output.print(messages.get("result") + score1 + " " + score2);
    }

    void show(Board board) {
        Output.print(board.toString());
    }

    void printFinalResults(String score1, String score2) {
        Output.print(messages.get("finalResult") + score1 + " " + score2);
    }

    void chooseLanguage() {
        Output.print("Witaj by wybrać język polski wybierz 1");
        Output.print("Welcome, in order to choose English language provide 2");
    }
}
