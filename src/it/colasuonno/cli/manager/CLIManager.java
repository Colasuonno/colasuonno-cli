package it.colasuonno.cli.manager;

import it.colasuonno.cli.debug.DefaultObject;
import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubComponent;
import it.colasuonno.cli.objects.sub.CLISubType;

import java.util.ArrayList;
import java.util.List;

public class CLIManager {

    private static List<CLIObject> objects = new ArrayList<>();

    public static CLIInput buildInput(String main, String... args) {
        CLISubComponent[] components = new CLISubComponent[args.length];
        for (int i = 0; i < args.length; i++) {
            components[i] = new CLISubComponent(args[i]);
        }
        return new CLIInput(
                main,
                components
        );
    }



    public static CLIOutput getDefaultOutput(){
        return (value,args)-> {
            {
            }
        };
    }

    public static CLIObject searchByMain(String main) {
        CLILogger.officialDebug(objects);
        return objects.stream()
                .filter(object -> object.getInput().getMain().equalsIgnoreCase(main))
                .findFirst()
                .orElse(new DefaultObject());
    }

    public static void register(CLIObject object) {
        objects.add(object);
    }

    public static List<CLIObject> getObjects() {
        return objects;
    }
}
