package phone.safe.lx.com.safephone.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by luis on 9/12/17.
 */

public class DateUtils {

    private static final String format_date = "MM-dd-yyyy";
    private static final String format_time = "HH:mm:ss";
    private static final String format_date_time = format_date + " " + format_time;

    private static DateFormat df;

    public static String getCurrentDate() {
        return getStringDate(format_date);
    }

    public static String getCurrentDateAndTime() {
        return getStringDate(format_date_time);
    }

    public static String getCurrentTime() {
        return getStringDate(format_time);
    }

    private static String getStringDate(String format) {
        df = new SimpleDateFormat(format);
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

}
