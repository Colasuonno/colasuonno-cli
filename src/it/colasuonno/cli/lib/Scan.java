package it.colasuonno.cli.lib;

import it.colasuonno.cli.CLI;
import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.objects.sub.CLIOutput;
import it.colasuonno.cli.objects.sub.CLISubType;

import javax.usb.UsbDevice;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

public class Scan extends CLIObject {

    public Scan() {
        super(CLIManager.buildInput("scan", "<value>"),
                new CLIExpectedSubComponent("<value>", CLISubType.VALUE, new CLIOutput() {
                    @Override
                    public void output(String[] value) {
                        switch (value[0]) {
                            case "wifi":
                                try {
                                    InetAddress localhost = InetAddress.getLocalHost();
                                    // this code assumes IPv4 is used
                                    byte[] ip = localhost.getAddress();

                                    for (int i = 1; i <= 254; i++) {
                                        ip[3] = (byte) i;
                                        InetAddress address = InetAddress.getByAddress(ip);
                                        if (address.isReachable(1000)) {
                                            info(address);
                                        } else if (!address.getHostAddress().equals(address.getHostName())) {
                                            CLILogger.i(address + " machine is known in a DNS lookup");
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "usb":
                                //Get UsbHub
                                try {
                                    //Get UsbHub
                                    UsbServices services = UsbHostManager.getUsbServices();
                                    UsbHub root = services.getRootUsbHub();

                                    listPeripherique(root);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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

    private static void listPeripherique(UsbHub hub) {
        //List all the USBs attached
        List perepheriques = hub.getAttachedUsbDevices();
        Iterator iterator = perepheriques.iterator();

        while (iterator.hasNext()) {

            UsbDevice perepherique = (UsbDevice) iterator.next();
            System.out.println(perepherique);

            if (perepherique.isUsbHub())
                listPeripherique((UsbHub) perepherique);

        }
    }

    private static void info(InetAddress address) {
        CLILogger.i("Host Address: " + address.getHostAddress());
        CLILogger.i("Host Name: " + address.getHostName());
        CLILogger.i("Host Name (Canonical): " + address.getCanonicalHostName());
    }

}
