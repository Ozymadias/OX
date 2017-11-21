package coregame;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    public int getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.nextLine();
    }
}
