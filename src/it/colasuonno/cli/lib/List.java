package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;

import java.io.File;

public class List extends CLIObject {

    public List() {
        super(CLIManager.buildInput("ls")
        );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {
        list();
    }

    private void list() {
        File file = new File(System.getProperty("user.dir"));
        if (file.listFiles() != null){
            CLILogger.green("Name                                        Size                                        Directory\n");
            for (File files : file.listFiles()){
                double size = Math.round(100.0D*(double)files.length()/(1024.0D*1024.0D))/100.0D;
                CLILogger.green(files.getName() + getSpaces(44,files.getName().length()) + size + " mb" +  getSpaces(44, String.valueOf(size).length()+3) + files.isDirectory());
            }
        } else CLILogger.red("List empty!");
    }

    private String getSpaces(int max, int length){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < max-length; i++){
            builder.append(" ");
        }
        return builder.toString();
    }

}
