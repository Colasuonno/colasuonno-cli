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

}
