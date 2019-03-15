package it.colasuonno.cli.objects.sub;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;

public class CLIExpectedSubComponent extends CLISubComponent {

    private CLISubType type;
    private CLIOutput output;
    private boolean total;

    public CLIExpectedSubComponent(String value, CLISubType type, CLIOutput output) {
        super(value);
        this.type = type;
        this.output = output;
    }


    public CLIExpectedSubComponent(String value, CLISubType type) {
       this(value,type, CLIManager.getDefaultOutput());
    }


    public void output(String[] args){
        output.output(args);
    }

    public boolean isTotal() {
        return total;
    }

    public CLISubType getType() {
        return type;
    }

    public CLIExpectedSubComponent setTotal(boolean value) {
        this.total = value;
        return this;
    }

    @Override
    public String toString() {
        return "CLIExpectedSubComponent{" +
                "type=" + type +
                '}';
    }
}
