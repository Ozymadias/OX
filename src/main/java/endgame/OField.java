package endgame;

public class OField implements Field {
    Sign s = Sign.O;

    @Override
    public boolean isTakenBy(Sign sign) {
        return sign.equals(s);
    }

    @Override
    public Sign signToPrint() {
        return s;
    }
}
