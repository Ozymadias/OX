package coregame;

public enum Sign {
    O, X;

    public Sign change() {
        return this == X ? O : X;
    }
}
