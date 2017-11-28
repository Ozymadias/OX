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
    private LocalPlayer first;
    private LocalPlayer second;

    public Match() {
        input = new Input();
        output = new Output();
        nameValidator = new NameValidator();
    }

    void play() {
        output.welcome();

        output.decideOutputType();
        output.changeState(input.getInt());

        output.decideNumberOfGamesInMatch();
        int numberOfGames = input.getInt();

        scoring = new Scoring(receiveScoring());

        receiveNames();
        scoring.register(first);
        scoring.register(second);

        for (int i = 0; i < numberOfGames; i++) {
            Game game = new Game(first, second);
            GameResults gameResults = game.play();
            scoring.update(gameResults);
            output.printResults(getScore(first), getScore(second));
        }

        output.gameOver();
        output.printFinalResults(getScore(first), getScore(second));
    }

    private void receiveNames() {
        output.askFirstName();
        first = new LocalPlayer(getName());
        output.askSecondName();
        second = new LocalPlayer(getName());
    }

    private Map<Result, Integer> receiveScoring() {
        Map<Result, Integer> resultToScoring = new HashMap<>();
        output.chooseScoreForWin();
        resultToScoring.put(WIN, input.getInt());
        output.chooseScoreForDraw();
        resultToScoring.put(DRAW, input.getInt());
        output.chooseScoreForLost();
        resultToScoring.put(LOSS, input.getInt());
        return resultToScoring;
    }

    private String getName() {
        String name = input.getString();
        while (!nameValidator.validate(name)) {
            output.wrongName();
            name = input.getString();
        }
        return name;
    }

    private String getScore(Player player) {
        return player.getName() + ":" + scoring.get(player);
    }
}
