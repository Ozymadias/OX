package player;

import coregame.Input;
import coregame.Position;

public class LocalPlayer implements Player {
    private final Input input;
    private final Validator validator;
    private final Parser parser;

    public LocalPlayer() {
        this.input = new Input();
        validator = new Validator();
        parser = new Parser();
    }

    @Override
    public Position makeMove() {
        String move;
        do{
            move = input.getString();
        }while (!validator.isValid(move));
        return parser.parse(move);
    }
}
