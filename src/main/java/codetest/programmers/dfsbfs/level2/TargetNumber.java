package codetest.programmers.dfsbfs.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TargetNumber {

    public int recursive(int[] numbers, int target, int idx, int sum, boolean minus) {
        sum = sum + (minus ? -numbers[idx] : numbers[idx]);

        if (idx == numbers.length - 1)
            return sum == target ? 1 : 0;

        return recursive(numbers, target, idx + 1, sum, true) + recursive(numbers, target, idx + 1, sum, false);
    }


    public int solution(int[] numbers, int target) {

        return recursive(numbers, target, 0, 0, true) + recursive(numbers, target, 0, 0, false);
    }

    @Test
    public void test() {

        int[] numbers = {3};
        int[][] testCases = {
                {1, 1, 1, 1, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solution(testCases[i], numbers[i]);
            log.info("## result : {}", result);
        }

    }
}
