package earlygame;

import coregame.Input;
import coregame.Messenger;

public class Host {
    private Input input;
    private Validator validator = new Validator();
    private Messenger messenger = new Messenger();
    private IntValidator intValidator = new IntValidator();

    public Host(Input input) {
        this.input = input;
    }

    public Coordinates decideBoardSize() {
        String move = input.getString();
        while (!validator.isValid(move)) {
            messenger.repeat();
            move = input.getString();
        }
        return Parser.parse(move);
    }

    public int provideWinningNumber() {
        String winningNb = input.getString();
        while (!intValidator.isValid(winningNb)) {
            messenger.repeat();
            winningNb = input.getString();
        }
        return IntParser.parse(winningNb);
    }
}
