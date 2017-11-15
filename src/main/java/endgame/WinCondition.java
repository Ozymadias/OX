package endgame;

/**
 * Wrapper for number of winning fields needed
 */
public class WinCondition {
    private int winningNumber;

    public WinCondition(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    int toInt() {
        return winningNumber;
    }
}
