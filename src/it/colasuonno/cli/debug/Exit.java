package it.colasuonno.cli.debug;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;

public class Exit extends CLIObject {

    public Exit() {
        super(CLIManager.buildInput("exit"));
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {
        CLILogger.officialDebug("Good bye :)", true);
        System.exit(1);
    }
}
