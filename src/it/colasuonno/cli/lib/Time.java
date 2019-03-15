package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIFollowedExpectedSubCommand;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;
import it.colasuonno.cli.utils.CLIUtils;

public class Time extends CLIObject {

    public Time() {
        super(CLIManager.buildInput("time", "<value>"),
                new CLIExpectedSubComponent("use", CLISubType.NOTHING, CLIManager.getDefaultOutput()),
                new CLIFollowedExpectedSubCommand("<value>", CLISubType.VALUE,
                        (value) -> CLILogger.i(CLIUtils.getDateString(value[0])),
                        "use", CLISubType.NOTHING, 2));
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {
        CLILogger.d(value + " - " + expected);
    }
}

