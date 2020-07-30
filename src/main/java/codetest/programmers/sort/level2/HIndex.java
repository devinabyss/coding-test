package codetest.programmers.sort.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class HIndex {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        log.info("## Sorted: {}", citations);
        int lastIdx = citations.length - 1;

        int lastCount = 0;
        int lastValue = 0;
        for (int i = lastIdx; i >= 0; i--) {
            int currentCount = citations.length - i;
            int curVal = citations[i];

            if (curVal == 0)
                break;

            if (curVal <= currentCount)
                return curVal == currentCount ? curVal : Math.max(curVal, lastCount);

            log.info("## CurVal : {}. CurCount : {}, LastVal : {}, LastCount : {}", curVal, currentCount, lastValue, lastCount);

            lastCount = currentCount;
            lastValue = curVal;
        }
        return Math.min(lastCount, lastValue);
    }

    @Test
    public void test() {

        int[][] tc = {
                {1, 1, 1, 1, 3, 7, 7, 7},
                {3, 0, 6, 1, 5},
                {1, 1, 1, 1, 1},
                {3, 3, 3, 5, 5, 6},
                {6, 6, 6},
                {0, 0, 0, 0, 1, 5, 6},
                {0, 0, 0, 0, 2, 5, 6},
                {0, 0, 0, 0},
                {1, 2, 3, 4, 5, 6, 7},
                {2, 2, 3, 4, 7},
                {0, 1, 3, 5, 5, 5, 5, 5, 5, 6}

        };
        for (int[] cur : tc) {
            int result = solution(cur);
            log.info("## Result : {} ", result);
        }


    }
}
