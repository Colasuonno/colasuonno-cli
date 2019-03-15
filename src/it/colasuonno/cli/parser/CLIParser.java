package it.colasuonno.cli.parser;

import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIObject;

public class CLIParser {


    public static CLIObject parse(String main, String[] args) {
        assert args != null : "Args cannot be null";
        return CLIManager.searchByMain(main);
    }

}
