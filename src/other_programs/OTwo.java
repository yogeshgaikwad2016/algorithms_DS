package other_programs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OTwo {
    public static final String DATE_DD_MMM_YYYY_PATTERN = "dd MMM yyyy";
    public static final ThreadLocal<DateFormat> DATE_DD_MMM_YYYY_FORMATTER = getSimpleDateFormat(DATE_DD_MMM_YYYY_PATTERN);
    public static final ThreadLocal<DateFormat> DATE_YYYY_MM_DD_LONG_FORMAT = getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    public static final ThreadLocal<DateFormat> DATE_YYYY_MM_DD_FORMATTER = getSimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {

        List<String> accountLevelCCA = new ArrayList<>();
        accountLevelCCA.add("thiss");

        List<Double> subscriptions = new ArrayList<>();
        subscriptions.add(2.11);
        subscriptions.add(2.11);

        for (Double subscription : subscriptions) {
            //Optional.ofNullable(subscription).ifPresent(accountLevelCCA::addAll);
        }

        System.out.println(subscriptions.toString());
    }

    public static Date parse(String date) {
        Date parsedDate = null;
        String parsedDate2 = null;
        Date parsedDate1 = null;
        try {
            parsedDate = DATE_YYYY_MM_DD_FORMATTER.get().parse(date);
            parsedDate2 = DATE_DD_MMM_YYYY_FORMATTER.get().format(parsedDate);
            parsedDate1 = DATE_DD_MMM_YYYY_FORMATTER.get().parse(parsedDate2);
        } catch (ParseException e) {
            System.out.println("ERROR: " + e);
        }
        return parsedDate1;
    }

    public static ThreadLocal<DateFormat> getSimpleDateFormat(String pattern) {
        return ThreadLocal.withInitial(() -> new SimpleDateFormat(pattern, Locale.ENGLISH));
    }

    public static int fun(int A, int B) {
        if (B == 0)
            return A;
        else
            return fun(B, A % B);
    }
}
