package coregame;

import endgame.JudgeLeaningTowardsOO;

import java.util.LinkedList;
import java.util.List;

public class AllMovesLinkedList implements AllMoves, Observed {
    private List<Move> moves = new LinkedList<>();
    private List<Observer> observers;

    public AllMovesLinkedList() {
        //add(JudgeLeaningTowardsOO);
    }

    @Override
    public void add(Move move) {
        moves.add(move);
        //notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer: observers) {
            observer.inform();
        }
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }
}
