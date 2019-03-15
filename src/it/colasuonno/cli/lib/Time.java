package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;

public class Time extends CLIObject {

    public Time() {
        super(CLIManager.buildInput("time", ""));
    }

    @Override
    public void output() {
        CLILogger.d("ciao");
    }
}

