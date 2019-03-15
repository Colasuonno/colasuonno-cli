package it.colasuonno.cli.debug;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIObject;

public class DefaultObject extends CLIObject {

    public DefaultObject() {
        super(CLIManager.buildInput(""));
    }

    @Override
    public void output() {
        CLILogger.d("sucas");
    }
}
