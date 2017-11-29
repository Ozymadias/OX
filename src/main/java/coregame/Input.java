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
            output.repeat();
            intString = this.getString();
        }
        return IntParser.parse(intString);
    }

    public String getString() {
        String s = scanner.nextLine();
        if (s.equals("Q"))
            System.exit(0);
        return s;
    }
}
