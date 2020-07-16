package programmers.oold.level2;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by HK on 2018-04-19.
 */
public class Year2016 {
    public String getDayName(int a, int b) {

        LocalDate localDate = LocalDate.of(2016, a, b);
        String answer = localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
        return answer;
    }

    public static void main(String[] args) {
        Year2016 test = new Year2016();
        int a = 5, b = 24;
        System.out.println(test.getDayName(a, b));
    }


}
