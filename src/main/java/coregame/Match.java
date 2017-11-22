package coregame;

import player.LocalPlayer;
import player.Player;

public class Match {
    private final Input input;
    private final Output output;
    private NameValidator nameValidator;
    private Scoring scoring = new Scoring();
    private Player first;
    private Player second;

    public Match() {
        input = new Input();
        output = new Output();
        nameValidator = new NameValidator();
    }

    void play() {
        output.print("Witaj w grze OX");
        first = new LocalPlayer(getName("pierwszego"));
        second = new LocalPlayer(getName("drugiego"));
        scoring.register(first);
        scoring.register(second);

        Game game = new Game(first, second);
        GameResults gameResults = game.play();
        scoring.update(first, gameResults.get(first));
        scoring.update(second, gameResults.get(second));
        printResults();
    }

    private String getName(String player) {
        output.print("Podaj imie " + player + " gracza");
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
