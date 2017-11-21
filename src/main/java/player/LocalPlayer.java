package player;

import coregame.Input;
import coregame.Output;
import coregame.Position;

public class LocalPlayer implements Player {
    private final Input input;
    private final Validator validator;
    private Output output;
    private IntValidator intValidator;

    public LocalPlayer() {
        this.input = new Input();
        validator = new Validator();
        output = new Output();
        intValidator = new IntValidator();
    }

    @Override
    public Position makeMove() {
        String move;
        move = input.getString();
        while (!validator.isValid(move)) {
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            move = input.getString();
        }
        return Parser.parse(move);
    }

    @Override
    public Position decideBoardSize() {
        return makeMove();
    }

    @Override
    public int provideWinningNumber() {
        String winningNb;
        winningNb = input.getString();
        while (!intValidator.isValid(winningNb)) {
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            winningNb = input.getString();
        }
        return IntParser.parse(winningNb);
    }
}
