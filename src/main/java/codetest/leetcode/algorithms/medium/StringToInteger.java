package codetest.leetcode.algorithms.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * medium
 * 8. String to Integer
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
@Slf4j
public class StringToInteger {

    public int myAtoi(String str) {
        String target = str.trim();
        String pattern = "^[ ]{0,}(^[-+]{0,1}[0-9]{1,}).{0,}$";
        Matcher matcher = Pattern.compile(pattern).matcher(target);
        boolean isMatch = matcher.matches();
        if (isMatch) {
            String numeric = matcher.group(1);

            try {
                return Integer.parseInt(numeric);
            } catch (NumberFormatException e) {
                return numeric.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        } else
            return 0;
    }

    public int isAcceptable(String str) {
        String target = str.trim();
        String pattern = "^[ ]{0,}([-+]{0,1}[0-9]{1,}).{0,}$";
        Matcher matcher = Pattern.compile(pattern).matcher(target);
        boolean isMatch = matcher.matches();
        if (isMatch) {
            String numeric = matcher.group();
            log.info("## numeric : {}", numeric);
            try {
                return Integer.parseInt(numeric);
            } catch (NumberFormatException e) {
                return numeric.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        } else
            return 0;


    }


    @Test
    public void test() {

        String[] tc = {
                "+1","42", "   -42", "4193 with words", "words and 987", "-91283472332"
        };
        for (int i = 0; i < tc.length; i++) {
            int result = myAtoi(tc[i]);
            log.info("## result : {}", result);
        }
    }


}
