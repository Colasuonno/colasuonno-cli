package it.colasuonno.cli.objects.sub;

public class CLIFollowedExpectedSubCommand extends CLIExpectedSubComponent {

    private String previousValue;
    private CLISubType previousType;

    public CLIFollowedExpectedSubCommand(String value, CLISubType type, CLIOutput output, String previousValue,CLISubType previousType) {
        super(value, type, output);
        this.previousValue = previousValue;
        this.previousType = previousType;
    }

    public String getPreviousValue() {
        return previousValue;
    }

    public CLISubType getPreviousType() {
        return previousType;
    }

    @Override
    public String toString() {
        return "CLIFollowedExpectedSubCommand{" +
                "previousValue='" + previousValue + '\'' +
                ", previousType=" + previousType +
                '}';
    }
}
