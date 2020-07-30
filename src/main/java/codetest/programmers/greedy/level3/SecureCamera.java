package codetest.programmers.greedy.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 * https://zzang9ha.tistory.com/133
 */
@Slf4j
public class SecureCamera {

    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));
        log.info("## Sorted : {}", Arrays.deepToString(routes));
        int count = 1;
        int[] last = routes[0];
        for (int i = 1; i < routes.length; i++) {
            //log.info("## Last : {}, Cur : {}", Arrays.toString(last), Arrays.toString(routes[i]));
            if (last[1] > routes[i][1]) {
                last = routes[i];
            } else if (last[1] < routes[i][0]) {
                last = routes[i];
                count++;
            }
        }
        return count;
    }


    @Test
    public void test() {
        int[][] input = new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int result = solution(input);
        log.info("## Result : {}", result);
    }
}
