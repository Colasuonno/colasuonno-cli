package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Read extends CLIObject {

    public Read() {
        super(CLIManager.buildInput("read", "<value>"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value, String[] totalArgs) {

                        String command = totalArgs[0];
                        String name = totalArgs[1];

                        switch (command) {
                            case "--normal":
                                File file = new File(System.getProperty("user.dir")+"\\"+name);
                                if (file.exists()){
                                    try {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();

                                        CLILogger.green("  <--- START --->   \n\n");

                                        BufferedReader br = new BufferedReader(new FileReader(name));

                                            String sCurrentLine;

                                            while ((sCurrentLine = br.readLine()) != null) {
                                                System.out.println(sCurrentLine);
                                            }

                                        CLILogger.green("\n\n  <--- END --->   g");

                                        } catch (Exception e){
                                        CLILogger.red("Something went wrong: " + e.getMessage());
                                    }
                                } else CLILogger.red("File doesn't exist");
                                break;
                            case "--advanced":
                                break;
                            default:
                                break;
                        }

                    }
                })
        );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {

    }
}
