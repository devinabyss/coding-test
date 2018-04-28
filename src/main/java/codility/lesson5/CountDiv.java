package codility.lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountDiv {

    private static final Logger logger = LoggerFactory.getLogger(CountDiv.class);

    public int solution(int A, int B, int K) {
        int minus = B - A;
        int div = minus / K;
        int result = (A % K == 0) || (A < K && minus > K) || (B % K == 0)  ? div + 1 : div;
        return result;
    }

    public static void main(String[] args) {
        //int[] input = { 6, 11, 2};zz
        //int[] input = { 1, 5, 3};
        //int[] input = {8, 28, 7};
        int[] input = {11, 345, 17};
        CountDiv countDiv = new CountDiv();

        int result = countDiv.solution(input[0], input[1], input[2]);

        logger.info("## result : {}", result);

        //logger.info("## {}", 5 / 0);
    }
}
