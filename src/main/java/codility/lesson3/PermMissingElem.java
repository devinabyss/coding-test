package codility.lesson3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * https://app.codility.com/demo/results/trainingM37BDZ-DPU/
 * Created by HK on 2018-04-20.
 */
public class PermMissingElem {

    private static final Logger logger = LoggerFactory.getLogger(PermMissingElem.class);

    public int solution(int[] A) {

        if (A.length == 0) {
            return 1;
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[0] + i) {
                return A[0] + i;
            }
        }

        return A[0] > 1 ? 1 : A[A.length - 1] + 1;
    }


    public static void main(String[] args) {
        int[] test = {};
        PermMissingElem permMissingElem = new PermMissingElem();
        int result = permMissingElem.solution(test);
        logger.info("## Result : {}", result);
    }


}
