package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;

import java.io.File;

public class Mkdir extends CLIObject {

    public Mkdir() {
        super(CLIManager.buildInput("mkdir", "input"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value, String[] totalArgs) {

                        String name = value[0];
                        try {
                             File file = new File(System.getProperty("user.dir")+"\\"+name);
                             CLILogger.green("Trying to create directory on path: " + file);
                             if (!file.exists()){
                                 if (file.mkdirs()) CLILogger.green("Directory " + name + " has been created");
                                 else CLILogger.red("Something went wrong, retry");
                             } else CLILogger.red("Directory already exists!");
                        } catch (Exception e){
                            CLILogger.red("Something went wrong: " + e.getMessage());
                        }

                    }
                })
                );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {

    }
}
