package it.colasuonno.cli.debug;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;

public class DefaultObject extends CLIObject {

    public DefaultObject() {
        super(CLIManager.buildInput(""));
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {
        CLILogger.d("sucas");
    }
}
