package player;

import coregame.Input;
import coregame.Output;
import coregame.Position;

public class LocalPlayer implements Player {
    private final Input input;
    private final Validator validator;
    private final Parser parser;
    private Output output;
    private IntValidator intValidator;
    private IntParser intParser;

    public LocalPlayer() {
        this.input = new Input();
        validator = new Validator();
        parser = new Parser();
        output = new Output();
        intValidator = new IntValidator();
        intParser = new IntParser();
    }

    @Override
    public Position makeMove() {
        String move;
        move = input.getString();
        while (!validator.isValid(move)) {
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            move = input.getString();
        }
        return parser.parse(move);
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
        return intParser.parse(winningNb);
    }
}
