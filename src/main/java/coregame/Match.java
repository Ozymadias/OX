package coregame;

import player.LocalPlayer;
import player.Player;

import java.util.EnumMap;
import java.util.Scanner;

import static coregame.Result.*;

public class Match {
    private final Input input;
    private final Messenger messenger;
    private NameValidator nameValidator;
    private Scoring scoring;
    private LocalPlayer first;
    private LocalPlayer second;

    public Match() {
        input = new Input();
        messenger = new Messenger();
        nameValidator = new NameValidator();
    }

    void play() {
        String language;
        Scanner s = new Scanner(System.in);
        do {
            messenger.chooseLanguage();
            language = s.nextLine();
        } while (!language.equals("1") && !language.equals("2"));
        if (language.equals("2"))
            Messenger.provide("english");
        else
            Messenger.provide("polish");

        messenger.settings();


        messenger.decideNumberOfGamesInMatch();
        int numberOfGames = input.getInt();

        scoring = new Scoring(receiveScoring());

        receiveNames();
        scoring.register(first);
        scoring.register(second);

        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game(first, second);
            GameResults gameResults = game.play(input);
            scoring.update(gameResults);
            messenger.printResults(getScore(first), getScore(second));
        }

        messenger.gameOver();
        messenger.printFinalResults(getScore(first), getScore(second));
    }

    private void receiveNames() {
        messenger.askFirstName();
        String firstName = getName();
        first = new LocalPlayer(firstName, input);

        String secondName = "";
        while (secondName.equals("") || secondName.equals(firstName)) {
            messenger.askSecondName();
            secondName = getName();
        }
        second = new LocalPlayer(secondName, input);
    }

    private EnumMap<Result, Integer> receiveScoring() {
        EnumMap<Result, Integer> resultToScoring = new EnumMap<>(Result.class);
        messenger.chooseScoreForWin();
        resultToScoring.put(WIN, input.getInt());
        messenger.chooseScoreForDraw();
        resultToScoring.put(DRAW, input.getInt());
        messenger.chooseScoreForLost();
        resultToScoring.put(LOSS, input.getInt());
        return resultToScoring;
    }

    private String getName() {
        String name = input.getString();
        while (!nameValidator.validate(name)) {
            messenger.wrongName();
            name = input.getString();
        }
        return name;
    }

    private String getScore(Player player) {
        return player.getName() + ":" + scoring.get(player);
    }
}
