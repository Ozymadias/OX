package coregame;

public class LocalPlayer implements Player {
    private final Input input;

    public LocalPlayer() {
        this.input = new Input();
    }

    @Override
    public Position makeMove() {
        return new Position(input.getInt(), input.getInt());
    }
}
