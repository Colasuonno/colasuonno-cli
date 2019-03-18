package it.colasuonno.cli.lib;

import com.sun.management.OperatingSystemMXBean;
import it.colasuonno.cli.CLI;
import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.ProcessorInfo;


import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.management.ManagementFactory.getOperatingSystemMXBean;

public class Info extends CLIObject {

    public Info() {
        super(CLIManager.buildInput("info", "<value>"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value, String[] totalArgs) {
                        switch (value[0]) {
                            case "pc":

                                CLILogger.i("CPU (Infos): ");
                                CLILogger.i("Identifier: " + System.getenv("PROCESSOR_IDENTIFIER"));
                                CLILogger.i("Architecture: " + System.getenv("PROCESSOR_ARCHITECTURE"));
                                CLILogger.i("Architew6432: " + System.getenv("PROCESSOR_ARCHITEW6432"));
                                CLILogger.i("Available processors (cores): " + System.getenv("NUMBER_OF_PROCESSORS"));
                                System.out.println(" ");
                                CLILogger.i("OS (Infos): ");
                                String nameOS = "os.name";
                                String versionOS = "os.version";
                                String architectureOS = "os.arch";
                                CLILogger.i("Name of the OS: " +
                                        System.getProperty(nameOS));
                                CLILogger.i("Version of the OS: " +
                                        System.getProperty(versionOS));
                                CLILogger.i("Architecture of THe OS: " +
                                        System.getProperty(architectureOS));

                                break;
                            default:
                                break;
                        }
                    }
                })
        );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {

    }

    public static int calcCPU(long cpuStartTime, long elapsedStartTime, int cpuCount)
    {
        long end = System.nanoTime();
        long totalAvailCPUTime = cpuCount * (end-elapsedStartTime);
        long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime()-cpuStartTime;
        //log("Total CPU Time:" + totalUsedCPUTime + " ns.");
        //log("Total Avail CPU Time:" + totalAvailCPUTime + " ns.");
        float per = ((float)totalUsedCPUTime*100)/(float)totalAvailCPUTime;
        CLILogger.i("PER: "+ per );
        return (int)per;
    }

}
