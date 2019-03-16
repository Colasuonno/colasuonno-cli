package it.colasuonno.cli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CLIUtils {

    /**
     * Gets the date by a format
     * @param format given for the result
     * @return the date
     */
    public static String getDateString(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date();
        return formatter.format(date);
    }

    /**
     * Method to format bytes in human readable format
     *
     * @param bytes
     *            - the value in bytes
     * @param digits
     *            - number of decimals to be displayed
     * @return human readable format string
     */
    public static String format(double bytes, int digits) {
        String[] dictionary = { "bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB" };
        int index;
        for (index = 0; index < dictionary.length; index++) {
            if (bytes < 1024) {
                break;
            }
            bytes = bytes / 1024;
        }
        return String.format("%." + digits + "f", bytes) + " " + dictionary[index];
    }

}
