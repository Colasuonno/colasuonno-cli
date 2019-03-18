package it.colasuonno.cli.parser;

import it.colasuonno.cli.debug.DefaultObject;
import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIFollowedExpectedSubCommand;
import it.colasuonno.cli.objects.sub.CLISubType;

import java.util.Arrays;

public class CLIParser {

    public static CLIObject parse(String main, String[] args) {
        assert args != null : "Args cannot be null";
        CLILogger.officialDebug("Args: " + Arrays.asList(args));
        CLIObject found = CLIManager.searchByMain(main);
        if (found instanceof DefaultObject) return found;
        if (args.length == 0) return found;
        else if (args.length <= found.getComponents().length) {
            CLIExpectedSubComponent expectedSubComponent = found.getComponents()[args.length - 1];
            String lastString = args[args.length - 1];

            if (expectedSubComponent instanceof CLIFollowedExpectedSubCommand) {

                if (args.length - 1 > 0) {
                    CLIFollowedExpectedSubCommand followed = (CLIFollowedExpectedSubCommand) expectedSubComponent;
                    String previous = args[args.length - followed.getAge()];

                    if (followed.getPreviousValue().equalsIgnoreCase(previous)) {
                        followed.output(followed.isTotal() ? args : new String[]{args[args.length-1]},args);
                    } else return null;

                } else return null;


            } else if (expectedSubComponent.getType().equals(CLISubType.VALUE) || expectedSubComponent.getValue().equalsIgnoreCase(args[args.length - 1])) {
                expectedSubComponent.output(expectedSubComponent.isTotal() ? args :new String[]{lastString},args);
            } else return null;
        }
        return null;
    }

}
