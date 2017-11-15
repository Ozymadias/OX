package endgame;

import coregame.Observer;

import java.util.Set;

public class JudgeLeaningTowardsOO implements Observer {


    private final WinCondition winCondition;
    private final BoardOO board;
    private Set<Field> oSequences;
    private Set<Field> xSequences;


    public JudgeLeaningTowardsOO(WinCondition winCondition, BoardOO board) {

        this.winCondition = winCondition;
        this.board = board;
    }

    public boolean wasThisAWinningMove(Sign s, Field f) {
        if (s.equals(Sign.X)) {
            if (oSequences.contains(f))
                return false;
            updateXSequences(f);
        } else {
            updateOSequences(f);
        }
        return false;
        /*

        O - X
        - O -
        - - -

        O can win diagonally down, vertically down in 1st column, horizontally right on 1st row
        X can't win in those sequences anymore, no need to ever check them for his winning move


 4
            - - o o o - - - -
            o o o O o o o - -
            - - o o o - - - -
            - o - o - o - - -
            o - - o - - o - -
            - - - - - - - - -
            - - - - - - - - -
            - - - - - - - - -



            - - o o o - - - -
            o x o O x - - - -
            - - o - o - - - -
            - x - - - x - - -
            o - - - - - o - -
            - - - - - - - - -
            - - - - - - - - -
            - - - - - - - - -

            - - - - - - - - -
            - - - - - - - - -
            - - - - X - - - -
            - - - - - - - - -
            - - - - - - - - -
            - - - - - - - - -
            - - - - - - - - -

         */

    }

    public void updateOSequences(Field f) {
        oSequences.add(f);
    }

    public void updateXSequences(Field field) {
        xSequences.add(field);
    }

    @Override
    public void inform() {

    }
}
