package codetest.leetcode.algorithms.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 9. Palindrome Number easy
 * https://leetcode.com/problems/palindrome-number/
 */
@Slf4j
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for (int i = 0; i < str.length() / 2; i++) {
            char left = str.charAt(i);
            char right = str.charAt(str.length() - 1 - i);
            if (!(left == right))
                return false;
        }
        return true;
    }

    @Test
    public void test() {

        int[] tc = {121, -121, 10};
        for (int i = 0; i < tc.length; i++) {
            boolean result = isPalindrome(tc[i]);
            log.info("## result : {}", result);
        }
    }
}
