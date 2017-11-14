import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    public int getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.next();
    }
}
