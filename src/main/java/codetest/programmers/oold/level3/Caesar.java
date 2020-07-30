package codetest.programmers.oold.level3;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/challenge_codes/22
 * <p>
 * Created by HK on 2018-04-21.
 */
class Caesar {

    // A-Z : 65 ~ 90
    // a-z : 97 ~ 122

    private static final Logger logger = LoggerFactory.getLogger(Caesar.class);

    enum Case {
        UPPER, LOWER, SPACE, ETC;
    }


    String caesar(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int realN = n % 26;

        s.chars().forEach(ch -> {
            Case type = returnCase(ch);
            logger.info("## Ch : {}", ch);
            switch (type) {
                case UPPER:
                    int upper = ch + realN;
                    if (upper > 90) {
                        upper -= 26;
                    }
                    sb.append(String.valueOf((char) upper));
                    break;

                case LOWER:
                    int lower = ch + realN;
                    if (lower > 122) {
                        lower -= 26;
                    }
                    sb.append(String.valueOf((char) lower));
                    break;

                default:
                    sb.append(String.valueOf((char) ch));
                    break;
            }

        });

        return sb.toString();
    }

    Case returnCase(int no) {
        if (no == 32) {
            return Case.SPACE;
        } else if (no > 64 && 91 > no) {
            return Case.UPPER;
        } else if (no > 95 && 123 > no) {
            return Case.LOWER;
        } else {
            return Case.ETC;
        }
    }

    String caesarLowPerformance(String s, int n) {
        //StringBuilder sb = new StringBuilder();

        String[] arr = s.split("\\s");


        logger.info("arr : {}", Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        int realN = n % 26;

        for (int i = 0; i < arr.length; i++) {
            arr[i].chars().forEach(ch -> {
                int sum = ch + realN;
                sum = (91 > ch && sum > 90) ? sum - 26 : sum;
                sum = ((123 > ch && ch > 96) && sum > 122) ? sum - 26 : sum;
                sb.append(Character.toString((char) sum));
            });
            if (i < arr.length - 1 || arr[i].length() == 0) {
                sb.append(" ");
            }
        }

        if (s.lastIndexOf(s.length() - 1) == 32) {
            sb.append(" ");
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Caesar c = new Caesar();

        Map<String, Object> test1 = Maps.newHashMap();
        test1.put("str", "a B z");
        test1.put("num", 4);


        Map<String, Object> test2 = Maps.newHashMap();
        test2.put("str", "gdbGubXeksAwvqQVEBOMgmuHQbwNnmd g gHBHAouHJ pNP wI");
        test2.put("num", 36);

        Map<String, Object> test3 = Maps.newHashMap();
        test3.put("str", " pldMwPvN  nAHzvutzzpxQDONoljrhkoiWVViGfsEgmPEOzBV");
        test3.put("num", 42);

        //logger.info("## Result : {}", c.caesar("a B z", 4));
        System.out.println(c.caesar("Kko v ", 27));
        //System.out.println(c.caesar((String) test3.get("str"), (Integer) test3.get("num")));
    }
}