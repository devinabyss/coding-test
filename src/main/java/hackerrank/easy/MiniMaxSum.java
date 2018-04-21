package hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by HK on 2018-04-21.
 */
public class MiniMaxSum {
    private static final Logger logger = LoggerFactory.getLogger(MiniMaxSum.class);

    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        int minPosition = arr.length - 2;//(arr.length - 1) / 2 + 1;
        long min = sum(arr, 0, minPosition);

        int maxPosition = arr.length - 1;//(arr.length) / 2 + 1;
        long max = sum(arr, 1, maxPosition);
        System.out.println(min + " " + max);

    }

    static long sum(int[] arr, int start, int end) {
        long sum = 0;
        boolean isEven = end - start % 2 == 0;
        int realEnd = isEven ? (end + start) / 2 : (end + start) / 2 + 1;
        //logger.info("## Array Length : {}, Start : {}, End : {}, RealEnd : {}", arr.length, start, end, realEnd);
        int count = 0;
        for (int i = start; i < realEnd; i++) {
            int partner = end - count;
            //logger.info("## I : {}, partner : {}", i, partner);
            if (i < partner) {
                sum += arr[i] + arr[partner];
                //logger.info("## sum : {}, array pos : {}, plused {}", sum, isEven ? end : end -i, arr[i] + arr[partner]);
            } else {
                sum += arr[i];
            }
            count++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {256741038, 623958417, 467905213, 714532089, 938071625};

        miniMaxSum(arr2);
    }
}
