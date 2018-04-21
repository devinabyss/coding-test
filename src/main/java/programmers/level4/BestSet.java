package programmers.level4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by HK on 2018-04-22.
 */
public class BestSet {

    private static final Logger logger = LoggerFactory.getLogger(BestSet.class);

    public int[] bestSet(int n, int s) {

        int[] answer = new int[n];

        if (n > s) {
            return new int[]{-1};
        }

        int p = s / n;
        int compare = s - (p * n);
        logger.info("## p : {}, compare : {}", p, compare);

        for (int i = 0; i < n; i++) {
            if (compare > 0) {
                answer[i] = p + 1;
                compare--;
            } else {
                answer[i] = p;
            }
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        BestSet c = new BestSet();

        System.out.println(Arrays.toString(c.bestSet(3, 13)));
    }
}
