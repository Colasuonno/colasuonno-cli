package it.colasuonno.cli;

import it.colasuonno.cli.lib.Convert;
import it.colasuonno.cli.lib.JSONHttp;
import it.colasuonno.cli.lib.Time;
import it.colasuonno.cli.objects.CLIComponent;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.parser.CLIParser;

import java.util.Scanner;

public class CLI {

    public static final boolean DEBUG = false;

    public static void main(String[] args) {

        new Time();
        new Convert();
        new JSONHttp();

        Scanner scanner = new Scanner(System.in);
        String found = scanner.nextLine();
        CLIComponent component = new CLIComponent(found);
        CLIObject object = CLIParser.parse(component.getMain(), component.getArgs());
        if (object != null) object.output(null, null);
        main(args);
    }

}
