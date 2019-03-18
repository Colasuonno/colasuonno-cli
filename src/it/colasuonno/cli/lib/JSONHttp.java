package it.colasuonno.cli.lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class JSONHttp extends CLIObject {

    public JSONHttp() {
        super(CLIManager.buildInput("jsonpage"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value, String[] totalArgs) {
                        String url = value[0];
                        try {
                            String genreJson = IOUtils.toString(new URL(url));
                            CLILogger.i("JSON (output): " + genreJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                })
                );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {

    }
}
