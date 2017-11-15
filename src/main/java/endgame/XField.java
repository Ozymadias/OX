package endgame;

public class XField implements Field {
    Sign s = Sign.X;

    @Override
    public boolean isTakenBy(Sign sign) {
        return sign.equals(s);
    }

    @Override
    public Sign signToPrint() {
        return s;
    }
}
