package codetest.leetcode.algorithms.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
@Slf4j
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == target)
                    return IntStream.of(i+1,j+1).toArray();
            }
        }
        return IntStream.of(0,0).toArray();
    }

    @Test
    public void test(){
        int[][] testArrays = {
                {2, 7, 11, 15}
        };
        int[] testTargets = {9};

        for (int i = 0; i < testArrays.length; i++) {
            int[] result = twoSum(testArrays[i], testTargets[i]);
            log.info("## Result : {}", Arrays.toString(result));
        }

    }
}
