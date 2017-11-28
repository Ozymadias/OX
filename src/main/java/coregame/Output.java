package coregame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Output {
    private static boolean isSystemOut = true;
    Map<String,String> messages;

    public Output() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("/home/dominik/IdeaProjects/OX/src/main/java/resources/Bundle.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        messages = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] columns = scanner.nextLine().split(" = ");
            messages.put(columns[0],columns[1]);
        }

        System.out.println(messages);
    }

    private void print(String s) {
        if (isSystemOut)
            System.out.println(s);
        else
            System.err.println(s);
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

    public void repeat() {
        print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
    }

    void welcome() {
        print("Witaj w grze OX");
    }

    void decideNumberOfGamesInMatch() {
        print("Wybierz liczbe po sobie nastepujacych gier w kolko i krzyzyk ktore beda tworzyc ten mecz");
    }

    void gameOver() {
        print("\nKoniec gry");
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

    void decideOutputType() {
        print("by zmienic domyslne wyjscie na wyjscie bledow wybierz 1");
    }


    void announceWin(String name) {
        print("zwyciezca jest " + name);
    }

    void turn(String name, Sign sign) {
        print("tura gracza: " + name + "(" + sign + ")");
    }

    void printResults(String score1, String score2) {
        print("wynik to: " + score1 + " " + score2);
    }

    void show(Board board) {
        print(board.toString());
    }

    void printFinalResults(String score1, String score2) {
        print("wynik calego meczu to: " + score1 + " " + score2);
    }

    void changeState(int i) {
        isSystemOut = i != 1;
    }
}
