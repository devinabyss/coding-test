package codetest.leetcode.algorithms.medium;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 완료 안됨 - 재귀로?
 * 12. Integer to Roman medium
 * https://leetcode.com/problems/integer-to-roman/
 */
@Slf4j
public class IntegerToRoman {
    public String intToRoman(int num) {
        log.info("## num : {}", num);

        int[] numbers = {1000, 500, 100, 50, 10, 5, 1};
        String[] strings = {"M", "D", "C", "L", "X", "V", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int div = num / numbers[i];
            num = num % numbers[i];
            String format = "%0" + String.valueOf(numbers[i] - 1).length() + "d";
            int rest = Integer.parseInt(String.format(format, num).substring(0, 1));

            //log.info("## i : {} , string : {}, div : {}, rest : {}", i, strings[i], div, rest);

            if (rest == 4 && String.valueOf(numbers[i]).substring(0, 1).equals("5")) {
                sb.append(strings[i].repeat(div));
                sb.append(strings[i + 1]).append(strings[i]);
                num -= 4 * numbers[i] / 5;
                i++;
            } else if (rest == 9 && String.valueOf(numbers[i]).substring(0, 1).equals("1")) {
                sb.append(strings[i].repeat(div));
                sb.append(strings[i + 2]).append(strings[i]);
                num -= 9 * numbers[i] / 10;
                //log.info("## num : {}, {}, {}", num, Integer.parseInt(String.format(format, 9)), format) ;
                i += 1;
            } else {
                sb.append(strings[i].repeat(div));
            }
        }
        return sb.toString();
    }

    //MCMXCIV
    private String partConvert(int i, int div, int rest, String[] strings) {
        log.info("## i : {} , string : {}, div : {}, rest : {}", i, strings[i], div, rest);
        StringBuilder sb = new StringBuilder();
        if (rest == 4)
            return sb.append(strings[i + 1]).append(strings[i]).toString();
        if (rest == 9)
            return sb.append(strings[i + 2]).append(strings[i - 1]).toString();
        return sb.append(Strings.repeat(strings[i], div)).toString();
    }


    @Test
    public void test() {
        int[] tc = {3, 4, 9, 58, 1994};
        for (int i = 0; i < tc.length; i++) {
            String result = intToRoman(tc[i]);
            log.info("## result : {}", result);
        }
    }
}
