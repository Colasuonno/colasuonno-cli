package it.colasuonno.cli.objects;

import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;

public abstract class CLIObject {

    private CLIInput input;
    private CLIExpectedSubComponent[] components;

    public CLIObject(CLIInput input, CLIExpectedSubComponent... components) {
        this.input = input;
        this.components = components;
        CLIManager.register(this);
    }

    public abstract void output(String value, CLIExpectedSubComponent expected);

    public CLIExpectedSubComponent[] getComponents() {
        return components;
    }

    public CLIInput getInput() {
        return input;
    }
}
