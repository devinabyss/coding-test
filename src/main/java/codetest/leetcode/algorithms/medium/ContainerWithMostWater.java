package codetest.leetcode.algorithms.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 11. Container With Most Water medium
 * https://leetcode.com/problems/container-with-most-water/
 */
@Slf4j
public class ContainerWithMostWater {

    private int recursive(int max, int x, int plus, int[] height) {

        if (x >= height.length - 1) return max;
        if (x + plus >= height.length) return Math.max(max, recursive(max, x + 1, 1, height));
        int h = Math.min(height[x], height[x + plus]);

        log.info("## plus : {},  h : {}, gop : {}", plus, h, h * plus);
        max = Math.max(h * plus, max);

        return Math.max(max, recursive(max, x, plus + 1, height));

    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; i + j < height.length; j++) {
                int target = i + j;
                int h = Math.min(height[i], height[target]);
                max = Math.max(max, h * j);
            }
        }
        return max;
    }

    @Test
    public void test() {

        int[][] tc = {
                {1, 8, 6, 2, 5, 4, 8, 3, 7}
        };

        for (int i = 0; i < tc.length; i++) {
            int result = maxArea(tc[i]);
            log.info("## result : {}", result);
        }
    }

}
