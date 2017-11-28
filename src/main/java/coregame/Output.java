package coregame;

public class Output {
    private void print(String s) {
        System.out.println(s);
    }

    void askAboutPosition() {
        print("podaj wpolrzedne pola w ktorym chcesz umiescic swoj znak w formacie \"rzad odstep kolumna\"");
    }

    void positionOutOfBoardOrRepeated() {
        print("podane dane przekraczaja zakres planszy lub powielaja wczesniejszy ruch, sprobuj ponownie");
    }

    void askAboutBoardSize() {
        print("podaj wymiary planszy w formacie \"rzedy odstep kolumny\" gdzie rzad i kolumna to liczby naturane wieksze od zera rozpoczynajace sie od cyfry roznej od zera");
    }

    void askWinningCondition() {
        print("podaj liczbe znakow niezbedna do wygranej");
    }

    void wrongWinningCondition() {
        print("liczba niezbedna do wygranej musi byc mniejsza niz jeden z wymiarow planszy oraz wieksza od zera, sprobuj jeszcze raz");
    }

    void announceDraw() {
        print("remis");
    }

    void turn(String name, Sign sign) {
        print("tura gracza: " + name + "(" + sign + ")");
    }

    void announceWin(String name) {
        print("zwyciezca jest " + name);
    }

    public void repeat() {
        print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
    }

    void welcome() {
        print("Witaj w grze OX");
    }

    void decideNumberOfGamesInMatch() {
        print("Wybierz liczbe po sobie nastepujacych gier w kolko i krzyzyk ktore beda tworzyc te rozgrywke");
    }

    void gameOver() {
        print("Koniec gry");
    }

    void chooseScoreForWin() {
        print("Wybierz liczbe punktow za zwyciestow");
    }

    void chooseScoreForDraw() {
        print("Wybierz liczbe punktow za remis");
    }

    void chooseScoreForLost() {
        print("Wybierz liczbe punktow za przegrana");
    }

    void askFirstName() {
        print("Podaj imie pierwszego gracza ktory bedzie gral znakiem X");
    }

    void askSecondName() {
        print("Podaj imie drugiego gracza ktory bedzie gral znakiem O");
    }

    void wrongName() {
        print("Imie moze skladac sie jedynie z liter, sprobuj jeszcze raz");
    }

    void printResults(String score1, String score2) {
        print("wynik to: " + score1 + " " + score2);
    }

    void show(Board board) {
        print(board.toString());
    }
}
