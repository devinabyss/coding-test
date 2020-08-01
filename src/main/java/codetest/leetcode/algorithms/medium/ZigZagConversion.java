package codetest.leetcode.algorithms.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * medium 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 */
@Slf4j
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (s.length() <= numRows)
            return s;

        List<StringBuilder> stringBuilderList = new ArrayList<>();


        int idx = 0;
        int cnt = 0;
        while (idx < s.length()) {

            StringBuilder sb = new StringBuilder();
            int rest = (cnt == 0) ? cnt % numRows : cnt % ((numRows - 1) == 0 ? 1 : numRows - 1);
            //log.info("## cnt : {}, idx : {}, numRows : {}, rest : {}", cnt, idx, numRows, rest);
            int subs = rest == 0 || rest == (numRows - 1) ? numRows : 1;

            if (subs == 1) {
                int preSpace = numRows - rest - 1;
                //log.info("## prespace : {}", preSpace);
                sb.append(" ".repeat(Math.max(0, preSpace)));
            }
            sb.append(s.substring(idx, Math.min(idx + subs, s.length())));
            sb.append(" ".repeat(Math.max(0, numRows - sb.toString().length())));
            idx += subs;
            cnt++;
            stringBuilderList.add(sb);
            //log.info("## subs : {}, sb : {}", subs, sb.toString());
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            //int start =
            for (int j = 0; j < stringBuilderList.size(); j++) {
                StringBuilder sb = stringBuilderList.get(j);
                if (sb.length() > i) {
                    String sub = sb.substring(i, i + 1);
                    result.append(sub.trim());
                }
            }
        }


        return result.toString();
    }


    @Test
    public void test() {

        String[] strings = {
                "AB",
                "PAYPALISHIRING",
                "PAYPALISHIRING"
        };
//          int subs = rest == 0 || rest == numRows - 1 ? numRows : 1;
// 4
//        PAYP; 0 1
//          A ; 1 2
//         L  ; 2 3
//        ISHI; 3 4
//          R ; 4 5
//         I  ; 5 6
//        NGAA; 6 7
        //  A ; 7 8
        // A  ; 8 9
        //AAAA; 9 10
        //
        int[] lines = {1, 3, 4};

        for (int i = 0; i < strings.length; i++) {
            String result = convert(strings[i], lines[i]);
            log.info("## result : {}", result);
        }
    }
}
