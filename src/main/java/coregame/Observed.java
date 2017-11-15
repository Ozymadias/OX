package coregame;

public interface Observed {
    void notifyAllObservers();
    void add(Observer observer);
}
