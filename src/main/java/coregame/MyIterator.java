package coregame;

interface MyIterator<T> {

    boolean hasNext();

    T next();

    boolean hasPrevious();

    T previous();

    void reset();
}
