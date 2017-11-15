package endgame;

public interface Field {

    boolean isTakenBy(Sign sign);
    Sign signToPrint();
}
