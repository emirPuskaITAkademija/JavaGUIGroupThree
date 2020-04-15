package six;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String formatCurrentDate(String pattern) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat(pattern);
        String formatedDate = dateFormater.format(currentDate);
        return formatedDate;
    }
}
