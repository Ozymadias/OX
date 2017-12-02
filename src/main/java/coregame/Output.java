package coregame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Output {
    private static boolean isSystemOut = true;
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

    private void print(String s) {
        if (isSystemOut)
            System.out.println(s);
        else
            System.err.println(s);
    }

    void askAboutPosition() {
        print(messages.get("askAboutPosition"));
    }

    void positionOutOfBoardOrRepeated() {
        print(messages.get("positionOutOfBoardOrRepeated"));
    }

    void askAboutBoardSize() {
        print(messages.get("askAboutBoardSize"));
    }

    void askWinningCondition() {
        print(messages.get("askWinningCondition"));
    }

    void wrongWinningCondition() {
        print(messages.get("wrongWinningCondition"));
    }

    void announceDraw() {
        print(messages.get("announceDraw"));
    }

    public void repeat() {
        print(messages.get("repeat"));
    }

    void settings() {
        print(messages.get("settings"));
    }

    void decideNumberOfGamesInMatch() {
        print(messages.get("decideNumberOfGamesInMatch"));
    }

    void gameOver() {
        print("\n" + messages.get("gameOver"));
    }

    void chooseScoreForWin() {
        print(messages.get("chooseScoreForWin"));
    }

    void chooseScoreForDraw() {
        print(messages.get("chooseScoreForDraw"));
    }

    void chooseScoreForLost() {
        print(messages.get("chooseScoreForLost"));
    }

    void askFirstName() {
        print(messages.get("askFirstName"));
    }

    void askSecondName() {
        print(messages.get("askSecondName"));
    }

    void wrongName() {
        print(messages.get("wrongName"));
    }

    void decideOutputType() {
        print(messages.get("decideOutputType"));
    }
    
    void announceWin(String name) {
        print(messages.get("announceWin") + name);
    }

    void turn(String name, Sign sign) {
        print(messages.get("turn") + name + "(" + sign + ")");
    }

    void printResults(String score1, String score2) {
        print(messages.get("result") + score1 + " " + score2);
    }

    void show(Board board) {
        print(board.toString());
    }

    void printFinalResults(String score1, String score2) {
        print(messages.get("finalResult") + score1 + " " + score2);
    }

    static void changeState(int i) {
        isSystemOut = i != 1;
    }
}
