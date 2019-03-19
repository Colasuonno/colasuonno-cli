package it.colasuonno.cli;

import it.colasuonno.cli.debug.Exit;
import it.colasuonno.cli.lib.*;
import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.objects.CLIComponent;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.parser.CLIParser;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.util.Scanner;

public class CLI {

    public static final boolean DEBUG = false;

    public static void main(String[] args) {

        new Time();
        new Convert();
        new JSONHttp();
        new FreeSpace();
        new Exit();
        new Scan();
        new Info();
        new WebPage();
        new Mkdir();
        new List();
        new Read();

        Scanner scanner = new Scanner(System.in);
        String found = scanner.nextLine();
        CLIComponent component = new CLIComponent(found);
        CLIObject object = CLIParser.parse(component.getMain(), component.getArgs());
        if (object != null) object.output(null, null);
        main(args);
    }

}
