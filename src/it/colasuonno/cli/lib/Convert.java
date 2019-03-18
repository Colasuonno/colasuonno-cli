package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIFollowedExpectedSubCommand;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;

import java.text.DecimalFormat;
import java.util.*;

public class Convert extends CLIObject {

    private static final Set<String> convertibleTo = new HashSet<>();

    static {
        convertibleTo.add("second->minute");
    }

    public Convert() {
        super(CLIManager.buildInput("convert", "<value>", "to", "<value>", "<value>"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE),
                new CLIExpectedSubComponent("to", CLISubType.NOTHING),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE),
                new CLIFollowedExpectedSubCommand("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value, String[] totalArgs) {

                        String from = value[0];
                        String to = value[2];

                        for (String a : convertibleTo) {

                            String[] split = a.split("->");
                            String key = split[0];
                            String _value = split[1];

                            if (from.contains(key) && to.contains(_value)) {
                                CLILogger.i(convert(a, value[3]));
                                break;
                            }
                        }
                    }
                }, "to", CLISubType.NOTHING, 3).setTotal(true)
        );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {

    }

    private static Object convert(String key, Object value) {
        switch (key) {
            case "second->minute":
                float floatValue = Float.parseFloat(String.valueOf(value));
                return (float)Math.round((floatValue/60.0f)*100)/100;
            default:
                return null;
        }
    }


}

