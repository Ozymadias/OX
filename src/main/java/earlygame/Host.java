package earlygame;

import coregame.Input;
import coregame.Output;

public class Host {
    private Input input;
    private Validator validator = new Validator();
    private Output output = new Output();
    private IntValidator intValidator = new IntValidator();

    public Host(Input input) {
        this.input = input;
    }

    public Coordinates decideBoardSize() {
        String move = input.getString();
        while (!validator.isValid(move)) {
            output.repeat();
            move = input.getString();
        }
        return Parser.parse(move);
    }

    public int provideWinningNumber() {
        String winningNb = input.getString();
        while (!intValidator.isValid(winningNb)) {
            output.repeat();
            winningNb = input.getString();
        }
        return IntParser.parse(winningNb);
    }
}
