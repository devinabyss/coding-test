package hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 * Created by HK on 2018-04-21.
 */
public class PlusMinus {

    private static final Logger logger = LoggerFactory.getLogger(PlusMinus.class);

    static void plusMinus(int[] arr) {

        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive++;
            } else if (0 > arr[i]) {
                negative++;
            } else {
                zero++;
            }
        }

        logger.info("## positive : {}, negative : {}, zero : {}", positive, negative, zero);

        System.out.println(new DecimalFormat("0.000000").format((positive > 0) ? ((double) positive) / (double) arr.length : (double) 0));
        System.out.println(new DecimalFormat("0.000000").format((negative > 0) ? ((double) negative) / (double) arr.length : (double) 0));
        System.out.println(new DecimalFormat("0.000000").format((zero > 0) ? ((double) zero) / (double) arr.length : (double) 0));

    }

    public static void main(String[] args) {


        int n = 6;
        int[] arrs = new int[n];
        String str = "-4 3 -9 0 4 1";

        String[] arr = str.split("\\s");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arr[arrItr].trim());
            arrs[arrItr] = arrItem;
        }

        plusMinus(arrs);
    }


}

