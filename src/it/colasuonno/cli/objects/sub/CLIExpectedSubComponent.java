package it.colasuonno.cli.objects.sub;

import it.colasuonno.cli.logger.CLILogger;

public class CLIExpectedSubComponent extends CLISubComponent {

    private CLISubType type;
    private CLIOutput output;

    public CLIExpectedSubComponent(String value, CLISubType type, CLIOutput output) {
        super(value);
        this.type = type;
        this.output = output;
    }

    public void output(String value){
        output.output(value);
    }

    public CLISubType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CLIExpectedSubComponent{" +
                "type=" + type +
                '}';
    }
}
