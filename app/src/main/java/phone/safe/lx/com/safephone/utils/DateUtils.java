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
    private static final String format_date_time = "MM-dd-yyyy HH:mm:ss";
    private static DateFormat df;

    public static String getCurrentDate() {
        df = new SimpleDateFormat(format_date);
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public static String getCurrentDateAndTime() {
        df = new SimpleDateFormat(format_date_time);
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

}
