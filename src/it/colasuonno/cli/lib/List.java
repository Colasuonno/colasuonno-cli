package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;
import javafx.scene.chart.ValueAxis;

import java.io.File;

public class List extends CLIObject {

    public List() {
        super(CLIManager.buildInput("ls"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value, String[] totalArgs) {

                        switch (value[0].toUpperCase()) {
                            case "-M":
                                list("MB");
                                break;
                            case "-G":
                                list("GB");
                                break;
                            case "-K":
                                list("KB");
                                break;
                            default:
                                list("MB");
                                break;
                        }

                    }
                })
        );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {
        list("MB");
    }

    private static void list(String type) {
        File file = new File(System.getProperty("user.dir"));
        if (file.listFiles() != null) {
            CLILogger.green("Name                                        Size                                        Directory\n");
            for (File files : file.listFiles()) {
                double size = 0.0D;
                switch (type) {
                    case "KB":
                        size = Math.round(100.0D * (double) files.length() / (1024.0D)) / 100.0D;
                        break;
                    case "MB":
                        size = Math.round(100.0D * (double) files.length() / (1024.0D * 1024.0D)) / 100.0D;
                        break;
                    case "GB":
                        size = Math.round(1000.0D * (double) files.length() / (1024.0D * 1024.0D * 1024.0D)) / 1000.0D;
                        break;
                }
                CLILogger.green(files.getName() + getSpaces(44, files.getName().length()) + size + " "+type.toLowerCase() + getSpaces(44, String.valueOf(size).length() + 3) + files.isDirectory());
            }
        } else CLILogger.red("List empty!");
    }

    private static String getSpaces(int max, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < max - length; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

}
