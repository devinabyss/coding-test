package codetest.leetcode.easy;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

@Slf4j
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target)
                    return IntStream.of(i,j).toArray();
            }
        }
        return IntStream.of(0,0).toArray();
    }


    @Test
    public void test() {
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
