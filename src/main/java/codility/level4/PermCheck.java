package codility.level4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/demo/results/trainingWPKCMC-T6A/
 * Result : 100%
 * Created by HK on 2018-04-21.
 */
public class PermCheck {

    private static final Logger logger = LoggerFactory.getLogger(PermCheck.class);

    public int base(int[] A) {

        Arrays.sort(A);
        int before = A[0];
        for (int i = 1; i < A.length; i++) {
            int compare = A[i] - before;
            if (!(compare == 1)) {
                return -1;
            }
            before = A[i];
        }
        return 1;
    }

    public int solution(int[] A) {

        int permSum = 0;
        for (int i = 1; i <= A.length; i++) {
            permSum += i;
        }

        boolean isEven = A.length % 2 == 0;

        int length = isEven ? A.length / 2 : (A.length - 1) / 2;
        int sum = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int front = A[i];
            int back = A[length * 2 - 1 - i];

            set.add(front);
            set.add(back);

            int sizeInarr = (i + 1) * 2;
            if (sizeInarr != set.size()) {
                return 0;
            }

            sum += front + back;
        }

        if (!isEven) {
            set.add(A[A.length - 1]);
            sum += A[A.length - 1];
        }

        return set.size() != A.length ? 0 : permSum == sum ? 1 : 0;
    }

    public static void main(String[] args) {

        int[] test1 = {4, 1, 3, 2};
        int[] test2 = {4, 1, 3};
        int[] test3 = {1, 4, 1};

        PermCheck perm = new PermCheck();
        LocalDateTime now = LocalDateTime.now();
        int result = perm.solution(test3);
        logger.info("## Result : {}, Time : {}", result, now.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }
}
