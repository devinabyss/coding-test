package hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/reduced-string/problem
 * Created by HK on 2018-04-19.
 */
public class SuperReducedString {

    private static final Logger logger = LoggerFactory.getLogger(SuperReducedString.class);

    public static String solution(String str) {

        boolean reduced = false;
        for (int i = 0; i < str.length() - 1; i++) {
            //logger.info("## String : {}, {}", str, i);
            int current = (int) str.charAt(i);
            int next = (int) str.charAt(i + 1);

            if (current == next) {
                reduced = true;
                if (i > 0) {
                    str = str.substring(0, i) + str.substring(i + 2);
                } else {
                    str = str.substring(i + 2);
                }
            }
        }
        return reduced ? solution(str) : str.length() == 0 ? "Empty String" : str;
    }

    public static void main(String[] args) {

        String[] inputList = {
                "aaabccddd",
                "aa",
                "baab",
                "lrfkqyuqfjjfquyqkfrlkxyqvnrtyssytrnvqyxkfrzrmzlygffgylzmrzrfveulqfpdbhhbdpfqluevlqdqrrcrwddwrcrrqdql"
        };

        SuperReducedString superReducedString = new SuperReducedString();
        Arrays.stream(inputList).forEach(str -> logger.info("## result : {}", superReducedString.solution(str)));
    }


}
