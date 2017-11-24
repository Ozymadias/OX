package coregame;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    public int getInt() {
        String intString;
        intString = this.getString();
        IntValidator intValidator = new IntValidator();
        while (!intValidator.isValid(intString)) {
            Output output = new Output();
            output.print("podane dane nie sa w odpowiednim formacie, sprobuj jeszcze raz");
            intString = this.getString();
        }
        return IntParser.parse(intString);
    }

    public String getString() {
        return scanner.nextLine();
    }
}
