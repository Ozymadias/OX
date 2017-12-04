package coregame;

import java.io.PrintStream;

class Output {
    static PrintStream printStream = System.out;

    static void print(String s) {
        printStream.println(s);
    }

    static void create(String outputSetting) {
        if (outputSetting.equals("err"))
            printStream = System.err;
    }
}
