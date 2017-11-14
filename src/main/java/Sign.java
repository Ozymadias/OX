enum Sign {
    X, O;

    public Sign change() {
        return this == X ? O : X;
    }
}
