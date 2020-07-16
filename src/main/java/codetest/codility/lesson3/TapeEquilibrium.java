package codetest.codility.lesson3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * https://app.codility.com/demo/results/trainingC5HAFK-S3X/
 * Result : 100%
 * Created by HK on 2018-04-20.
 */
public class TapeEquilibrium {

    private static final Logger logger = LoggerFactory.getLogger(TapeEquilibrium.class);

    public int lowPerformance(int[] A) {

        Integer min = null;

        for (int i = 0; i < A.length - 1; i++) {
            int[] first = new int[i + 1];
            int[] second = new int[A.length - (i + 1)];

            for (int j = 0; j <= i; j++) {
                first[j] = A[j];
                //first.add(A[j]);
            }

            for (int k = i + 1; k < A.length; k++) {
                //logger.info(": {}, {}", k, Arrays.toString(second));
                second[k - i - 1] = A[k];
                //second.add(A[k]);
            }

            int firstSum = Arrays.stream(first).sum();
            //first.stream().mapToInt(Integer::intValue).sum();
            int secondSum = Arrays.stream(second).sum();
            //second.stream().mapToInt(Integer::intValue).sum();
            int result = Math.abs(firstSum - secondSum);
            logger.info("## first : {}, second : {}, min array : {}", firstSum, secondSum, result);
            min = Optional.ofNullable(min).isPresent() ? min > result ? result : min : result;

        }

        return min;
    }

    public int solution(int[] A) {

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int front = 0;
        int min = 100000;

        for (int i = 0; i < A.length - 1; i++) {
            front += A[i];
            int result = Math.abs(front - (sum - front));
            //logger.info("re {}", result);
            min = min > result ? result : min;
            if (min == 0) {
                return min;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        // int[] test = {-1000, 1000}; // 2000
        // int[] test = {5, 6, 2, 4, 1}; // 4
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(random.nextInt(100));
        }

        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        LocalDateTime now = LocalDateTime.now();
        int result = tapeEquilibrium.solution(list.stream().mapToInt(Integer::intValue).toArray());
        logger.info("## Result : {}, Time : {}", result, now.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }
}
