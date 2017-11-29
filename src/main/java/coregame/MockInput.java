package coregame;

class MockInput extends Input{
    private final String[] mockedInput;
    private int iterator = 0;

    MockInput(String[] mockedInput) {
        this.mockedInput = mockedInput;
    }

    @Override
    public String getString() {
        return mockedInput[iterator++];
    }
}
