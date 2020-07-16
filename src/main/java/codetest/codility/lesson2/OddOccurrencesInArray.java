package codetest.codility.lesson2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

/**
 * https://app.codility.com/demo/results/trainingKVGNQ4-UN3/
 *
 * Created by HK on 2018-04-20.
 */
public class OddOccurrencesInArray {

    private static final Logger logger = LoggerFactory.getLogger(OddOccurrencesInArray.class);

    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        Integer compare = null;
        for (int i = 0; i < A.length; i++) {
            Optional optional = Optional.ofNullable(compare);
            if (optional.isPresent()) {
                if (optional.get().hashCode() == A[i]) {
                    count++;
                } else {

                    if (count % 2 == 0) {
                        count = 0;
                    } else {
                        return A[i];
                    }
                }
            }
            compare = A[i];
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] test = {9, 3, 9, 3, 9, 7, 9};

        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int result = oddOccurrencesInArray.solution(test);

        logger.info("## Result :{}", result);
    }


}
