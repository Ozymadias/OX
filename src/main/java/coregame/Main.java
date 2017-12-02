package coregame;

public class Main {
    public static void main(String[] args) {
        System.out.println("  _____      _      _          _                  _     _                    _______              _          \n" +
                " |  __ \\    (_)    | |        (_)                (_)   | |                  |__   __|            | |         \n" +
                " | |  | |_____  ___| | ___   _ _  ___   _ __ ___  _ ___| |_ _ __ _____   _     | | ___  _ __ ___ | | ___   _ \n" +
                " | |  | |_  / |/ _ \\ |/ / | | | |/ _ \\ | '_ ` _ \\| / __| __| '__|_  / | | |    | |/ _ \\| '_ ` _ \\| |/ / | | |\n" +
                " | |__| |/ /| |  __/   <| |_| | |  __/ | | | | | | \\__ \\ |_| |   / /| |_| |    | | (_) | | | | | |   <| |_| |\n" +
                " |_____//___|_|\\___|_|\\_\\\\__,_| |\\___| |_| |_| |_|_|___/\\__|_|  /___|\\__,_|    |_|\\___/|_| |_| |_|_|\\_\\\\__,_|\n" +
                "                             _/ |                                                                            \n" +
                "                            |__/                                                                             ");
        Output.create(args.length > 0 ? args[0] : "");
        Match match = new Match();
        match.play();
    }
}
