package codetest.leetcode.algorithms.hard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * 10. Regular Expression Matching hard
 * https://leetcode.com/problems/regular-expression-matching/
 */

@Slf4j
public class RegularExpressionMatching {

    /**
     * 직접 구현 샘플 3번 아직 해결 안됨.
     */
    public boolean isMatch(String s, String p) {
        int strIdx = 0;
        int patternIdx = 0;
        boolean starUsing = false;
        char pre = 0;
        while (strIdx < s.length()) {
            char currentStr = s.charAt(strIdx);
            if (patternIdx >= p.length()) return false;
            char currentPattern = p.charAt(patternIdx);
            char nextPattern = nextChar(patternIdx, 0, p);
            boolean isStar = nextPattern == 42;
            log.info("## strIdx : {}, patternIdx : {}, currentStr : {}, preStr : {}, currentPattern : {}, nextPattern : {}, isStar : {}, starUsing : {}",
                    strIdx, patternIdx, currentStr, pre, currentPattern, nextPattern, isStar, starUsing);

            if (isStar) {
                if (starUsing) {
                    if (!isMatchCharacter(pre, currentStr) && currentPattern != 46) {
                        char nextRealPattern = nextChar(patternIdx, 1, p);
                        log.info("## NextReal : {}", nextRealPattern);
                        if (!isMatchCharacter(currentStr, nextRealPattern)) return false;
                        patternIdx += 3;
                        starUsing = false;
                    }
                } else {
                    pre = currentStr;
                    starUsing = true;
                }
            } else {
                if (!isMatchCharacter(currentStr, currentPattern)) return false;
                patternIdx++;
            }
            strIdx++;
            //if (patternIdx >= p.length()) return false;
        }
        return true;

    }

    private char nextChar(int currentIdx, int skipIdx, String string) {
        return string.length() - 1 - skipIdx <= currentIdx ? 0 : string.charAt(currentIdx + 1 + skipIdx);
    }

    private boolean isMatchCharacter(char str, char pattern) {
        boolean a = pattern == 46 || str == pattern;
        log.info("## isMatchCharacter : {}, Str : {}, Pattern : {}", a, str, pattern);
        return a;
    }


    @Test
    public void test() {

        String[] strings = {

                "aa", "aa", "ab", "aab"
                , "mississippi",
                "mississippi"
        };
        String[] patterns = {
                "a", "a*", ".*", "c*a*b"
                , "mis*is*p*.",
                 "mis*is*ip*."
        };

        for (int i = 0; i < strings.length; i++) {
            boolean result = isMatch(strings[i], patterns[i]);
            log.info("## result : {}", result);
        }
    }


    public boolean usingRegexp(String s, String p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch (cur) {
                case 42: // *
                    if (i > 0 && s.charAt(i - 1) == 46) {
                        sb.delete(sb.length() - 4, sb.length());
                        sb.append(".");
                    }

                    sb.append("{0,}");
                    break;

                case 46: // .
                    sb.append(".{1}");
                    break;

                default:
                    sb.append(cur);
                    break;
            }
        }
        String pattern = sb.toString();
        return Pattern.matches(pattern, s);

    }
}
