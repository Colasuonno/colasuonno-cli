package it.colasuonno.cli.objects;

import it.colasuonno.cli.manager.CLIManager;

public abstract class CLIObject {

    private CLIInput input;

    public CLIObject(CLIInput input) {
        this.input = input;
        CLIManager.register(this);
    }

    public abstract void output();

    public CLIInput getInput() {
        return input;
    }
}
