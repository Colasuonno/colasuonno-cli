package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIFollowedExpectedSubCommand;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;
import org.apache.commons.io.IOUtils;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;

public class WebPage extends CLIObject {

    public WebPage() {
        super(CLIManager.buildInput("webpage", "<value>", "<value>"),
                new CLIExpectedSubComponent("--status", CLISubType.NOTHING),
                build(), build()
        );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {

    }

    private static CLIExpectedSubComponent build() {
        return new CLIExpectedSubComponent("<value>", CLISubType.VALUE, (value, totalArgs) -> {

            String ip = totalArgs[totalArgs.length-1];
            boolean self = false;
            try {
                if (ip.equalsIgnoreCase("me")) {
                    ip = InetAddress.getLocalHost().getHostAddress();
                    self = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                InetAddress address = self ? InetAddress.getLocalHost() : InetAddress.getByName(new URL(ip).getHost());
                if (!self) {
                    CLILogger.green("Loading page with ip: " + ip);
                    HttpURLConnection connection = (HttpURLConnection) new URL(ip).openConnection();
                    connection.setRequestMethod("HEAD");
                    CLILogger.green("Connecting to " + ip);
                    int responseCode = connection.getResponseCode();
                    if (responseCode != 200) {
                        CLILogger.red("Page might have some problems");
                    } else {
                        CLILogger.i("Webpage seems online!");
                        CLILogger.i("Response message: " + connection.getResponseMessage());
                        CLILogger.green("Trying to fetch InetAddress by URL(" + ip + ")");
                        CLILogger.i("InetAddress (ip): " + address.getHostAddress());
                        CLILogger.i("Hostname: " + address.getHostName());


                    }
                    CLILogger.i("WebResponse (code): " + responseCode);
                } else{
                    CLILogger.green("Found local webpage check");

                    CLILogger.i("InetAddress (ip): " + address.getHostAddress());
                    CLILogger.i("Hostname: " + address.getHostName());

                }

                if (totalArgs.length == 3 && totalArgs[1].equalsIgnoreCase("-json")) {
                    String genreJson = IOUtils.toString(new URL("http://ip-api.com/json/" + address.getHostAddress()));
                    CLILogger.i("JSON (output): " + genreJson);
                }


            } catch (Exception e) {
                CLILogger.red("Something went wrong: " + e.getMessage());
            }

        });
    }

}
