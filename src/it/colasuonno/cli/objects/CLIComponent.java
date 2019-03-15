package it.colasuonno.cli.objects;

import java.util.List;

public class CLIComponent {

    private String main;
    private String[] args;

    public CLIComponent(String input) {
        String[] space = input.split(" ");
        String[] args = new String[space.length-1];
        this.main = space[0];
        for (int i = 1; i < space.length; i++){
            args[i] = space[i];
        }
        this.args = args;
    }

    public String getMain() {
        return main;
    }

    public String[] getArgs() {
        return args;
    }
}
