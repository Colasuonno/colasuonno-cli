package it.colasuonno.cli;

import it.colasuonno.cli.lib.Time;
import it.colasuonno.cli.objects.CLIComponent;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.parser.CLIParser;

import java.util.Scanner;

public class CLI {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {

        new Time();

        Scanner scanner = new Scanner(System.in);
        String found = scanner.nextLine();
        CLIComponent component = new CLIComponent(found);
        CLIObject object = CLIParser.parse(component.getMain(), component.getArgs());
        if (object != null) object.output(null, null);
        main(args);
    }

}
