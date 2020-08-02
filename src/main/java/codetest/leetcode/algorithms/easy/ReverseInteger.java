package codetest.leetcode.algorithms.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * easy
 * https://leetcode.com/problems/reverse-integer/
 */
@Slf4j
public class ReverseInteger {

    public int reverse(int x) {

        boolean isPlus = Integer.signum(x) >= 0;

        String str = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            ch = ch == 33 ? 32 : ch;
            sb.append(ch);
        }

        String target = sb.toString();
        target = target.trim();
        target = target.replaceAll(" ", "0");

        try {
            return isPlus ? Integer.parseInt(target) : Integer.parseInt(target) * -1;
        } catch (NumberFormatException e) {
            return 0;
        }

    }


    @Test
    public void test() {
        int[] tc = {123, -123, 120
                //,9646324351 // if overflow, return 0
        };

        for (int i = 0; i < tc.length; i++) {
            int result = reverse(tc[i]);
            log.info("## result : {}", result);
        }
    }
}
