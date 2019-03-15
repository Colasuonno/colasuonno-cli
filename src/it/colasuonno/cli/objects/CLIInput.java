package it.colasuonno.cli.objects;

import it.colasuonno.cli.objects.sub.CLISubComponent;

import java.util.List;

public class CLIInput {

    private String main;
    private CLISubComponent[] args;

    public CLIInput(String main, CLISubComponent[] args) {
        this.main = main;
        this.args = args;
    }

    public String getMain() {
        return main;
    }

    public CLISubComponent[] getArgs() {
        return args;
    }
}
