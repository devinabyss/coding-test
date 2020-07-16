package codetest.hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by HK on 2018-04-21.
 */
public class BirthdayCakeCandles {
    private static final Logger logger = LoggerFactory.getLogger(BirthdayCakeCandles.class);

    static int birthdayCakeCandles(int n, int[] ar) {


        int max = Arrays.stream(ar).max().orElse(0);
        return (int) Arrays.stream(ar).filter(candle -> candle == max).count();


    }


    public static void main(String[] args) throws IOException {

        int age = 4;
        int[] candles = {3, 1, 2, 3};

        int result = birthdayCakeCandles(age, candles);

        logger.info("## Result : {}", result);

    }
}
