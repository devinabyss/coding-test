package hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 * Created by HK on 2018-04-22.
 */
public class TimeConversion {

    private static final Logger logger = LoggerFactory.getLogger(TimeConversion.class);

    static String timeConversion(String s) {

        String[] arr = s.split(":");

        String ampm = arr[2].substring(2);

        StringBuilder sb = new StringBuilder();

        int hour = Integer.valueOf(arr[0]);

        String hourStr = String.format("%02d", ampm.equals("PM") ? hour == 12 ? 12 : hour + 12 : hour == 12 ? 0 : hour);
        sb.append(hourStr).append(":");
        sb.append(arr[1]).append(":").append(arr[2].substring(0, 2));

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        String time = "12:45:54PM";

        String result = timeConversion(time);

        logger.info("## Result : {}", result);

    }
}
