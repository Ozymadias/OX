package coregame;

import player.LocalPlayer;
import player.Player;

import java.util.HashMap;
import java.util.Map;

import static coregame.Result.*;

public class Match {
    private final Input input;
    private final Output output;
    private NameValidator nameValidator;
    private Scoring scoring;
    private Player first;
    private Player second;

    public Match() {
        input = new Input();
        output = new Output();
        nameValidator = new NameValidator();
    }

    void play() {
        output.print("Witaj w grze OX");
        output.print("Wybierz liczbe po sobie nastepujacych gier w kolko i krzyzyk ktore beda tworzyc te rozgrywke");
        int numberOfGames = input.getInt();

        Map<Result, Integer> resultToScoring = new HashMap<>();
        output.print("Wybierz liczbe punktow za zwyciestow");
        resultToScoring.put(WIN, input.getInt());
        output.print("Wybierz liczbe punktow za remis");
        resultToScoring.put(DRAW, input.getInt());
        output.print("Wybierz liczbe punktow za przegrana");
        resultToScoring.put(LOSS, input.getInt());
        scoring = new Scoring(resultToScoring);

        first = new LocalPlayer(getName("pierwszego", "X"));
        second = new LocalPlayer(getName("drugiego", "O"));
        scoring.register(first);
        scoring.register(second);

        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game(first, second);
            GameResults gameResults = game.play();
            scoring.update(gameResults);
            printResults();
        }
        output.print("Koniec gry");
    }

    private String getName(String player, String signString) {
        output.print("Podaj imie " + player + " gracza ktory bedzie gral znakiem " + signString);
        String name = input.getString();
        while (!nameValidator.validate(name)) {
            output.print("Imie moze skladac sie jedynie z liter, sprobuj jeszcze raz");
            name = input.getString();
        }
        return name;
    }

    private void printResults() {
        output.print("wynik to: " + getScore(first) + " " + getScore(second));
    }

    private String getScore(Player player) {
        return player.getName() + ":" + scoring.get(player);
    }
}
