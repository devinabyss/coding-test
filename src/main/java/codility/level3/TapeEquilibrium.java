package codility.level3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by HK on 2018-04-20.
 */
public class TapeEquilibrium {

    private static final Logger logger = LoggerFactory.getLogger(TapeEquilibrium.class);

    public int solution(int[] A) {

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

    public static void main(String[] args) {

        int[] test = {-10, -20, -30, -40, 100};
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int result = tapeEquilibrium.solution(test);
        logger.info("## Result : {}", result);
    }
}
