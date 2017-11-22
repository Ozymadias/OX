package coregame;

import player.LocalPlayer;
import player.Player;

public class Match {
    private final Input input;
    private final Output output;
    private NameValidator nameValidator;

    public Match() {
        input = new Input();
        output = new Output();
        nameValidator = new NameValidator();
    }

    void play() {
        output.print("Witaj w grze OX");
        Player first = new LocalPlayer(getName("pierwszego"));
        Player second = new LocalPlayer(getName("drugiego"));
        Game game = new Game(first, second);
        game.play();
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
}
