package other_programs;

import java.util.Calendar;
import java.util.Date;

public class GCITesting {

    public static void main(String[] args) {
        //System.out.println(getShiftedDate(new Date(2023- 6 -25), Calendar.DAY_OF_MONTH, -1));
    }

    public static Date getShiftedDate(Date date, int type, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, count);
        return calendar.getTime();
    }
}
