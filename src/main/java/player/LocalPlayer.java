package player;

import coregame.Input;
import coregame.Messenger;
import coregame.Position;

import java.util.Optional;

public class LocalPlayer implements Player {
    private final Input input;
    private final Validator validator;
    private final String name;
    private Messenger messenger;

    public LocalPlayer(String name, Input input) {
        this.input = input;
        this.name = name;
        validator = new Validator();
        messenger = new Messenger();
    }

    @Override
    public Optional<Position> makeMove() {
        String move;
        move = input.getString();
        while (!validator.isValid(move) && !move.equals("S")) {
            messenger.repeat();
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
