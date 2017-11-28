package player;

import coregame.Input;
import coregame.Output;
import coregame.Position;

public class LocalPlayer implements Player {
    private final Input input;
    private final Validator validator;
    private final String name;
    private Output output;

    public LocalPlayer(String name) {
        this.input = new Input();
        this.name = name;
        validator = new Validator();
        output = new Output();
    }

    @Override
    public Position makeMove() {
        String move;
        move = input.getString();
        while (!validator.isValid(move)) {
            output.repeat();
            move = input.getString();
        }
        return Parser.parse(move);
    }

    public String getName() {
        return name;
    }
}
