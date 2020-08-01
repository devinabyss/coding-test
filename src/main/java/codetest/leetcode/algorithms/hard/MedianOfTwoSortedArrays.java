package codetest.leetcode.algorithms.hard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 이문제는 뭐지? 난이도가 하드인데, API 만 쓰면 정답 퍼포먼스가 나옴..
 *
 * hard
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
@Slf4j
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> sum = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        sum.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Collections.sort(sum);

        log.info("## list : {}", sum);

        boolean isEvenSize = sum.size() % 2 == 0;
        int center = sum.size() / 2;

        return isEvenSize ? new BigDecimal( String.valueOf(sum.get(center-1) + sum.get(center))).divide(BigDecimal.valueOf(2)).floatValue() : sum.get(center);
    }

    @Test
    public void test() {

        int[][] tc1 = {
                {1, 3},
                {1, 2}
        };
        int[][] tc2 = {
                {2},
                {3, 4}
        };

        for (int i = 0; i < tc1.length; i++) {
            double result = findMedianSortedArrays(tc1[i], tc2[i]);
            log.info("## result : {}", result);
        }

    }
}
