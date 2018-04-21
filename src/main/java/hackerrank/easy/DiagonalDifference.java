package hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HK on 2018-04-22.
 */
public class DiagonalDifference {

    private static final Logger logger = LoggerFactory.getLogger(DiagonalDifference.class);

    static int diagonalDifference(int[][] a) {


        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < a.length; i++) {
            //logger.info("## a[i] : {}", Arrays.toString(a[i]));
            sum1 += a[i][i];
            sum2 += a[i][a[i].length - 1 - i];

        }
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] a = {{11, 2, 4,}, {4, 5, 6}, {10, 8, -12}};


        int result = diagonalDifference(a);

        logger.info("## Result : {}", result);

    }
}
