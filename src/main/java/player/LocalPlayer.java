package player;

import coregame.Input;
import coregame.Output;
import coregame.Position;

import java.util.Optional;

public class LocalPlayer implements Player {
    private final Input input;
    private final Validator validator;
    private final String name;
    private Output output;

    public LocalPlayer(String name, Input input) {
        this.input = input;
        this.name = name;
        validator = new Validator();
        output = new Output();
    }

    @Override
    public Optional<Position> makeMove() {
        String move;
        move = input.getString();
        while (!validator.isValid(move) && !move.equals("S")) {
            output.repeat();
            move = input.getString();
        }
        if (!move.equals("S"))
            return Optional.of(Parser.parse(move));
        else
            return Optional.empty();
    }

    public String getName() {
        return name;
    }
}
