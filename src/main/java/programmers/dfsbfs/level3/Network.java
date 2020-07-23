package programmers.dfsbfs.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Network {

    public int solution(int n, int[][] computers) {

        for (int i =0; i< n; i++) {

        }
        return 0;
    }


    @Test
    public void test() {

        int[] n = {3, 3};
        int[][][] testCases = {
                {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
                {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
        };

        for (int i = 0; i < n.length; i++) {
            int result = solution(n[i], testCases[i]);
            log.info("## result : {}", result);
        }

    }
}
