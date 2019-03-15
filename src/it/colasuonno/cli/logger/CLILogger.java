package it.colasuonno.cli.logger;

import it.colasuonno.cli.CLI;

public class CLILogger {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void d(Object message){
        System.out.println(ANSI_RED + "[CLI-DEBUG] " + message);
    }

    public static void i(Object message){
        System.out.println(ANSI_PURPLE + "[CLI-INFO] " + message);
    }

    public static void officialDebug(Object message){
        if (CLI.DEBUG) System.out.println(ANSI_CYAN + "[CLI-OFFICIAL-DEBUG] " + message);
    }

}
