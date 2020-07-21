package codetest.hackerrank.middle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by HK on 2018-04-15.
 */
public class ValidString {

    private static final Logger logger = LoggerFactory.getLogger(ValidString.class);

    static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 >= o2 ? o1 : o2;
        }
    };

    static String isValid(String s) {

        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1).toLowerCase();
            int count = Optional.ofNullable(counts.get(str)).orElse(0);
            counts.put(str, count + 1);
        }

        logger.info("Counts Map : {}", counts);

        Map<Integer, Integer> counts2 = new HashMap<>();

        for (Integer count : counts.values()) {
            Integer c = Optional.ofNullable(counts2.get(count)).orElse(0);
            counts2.put(count, c + 1);
        }

        logger.info("Counts2 Map : {}", counts2);


        if (counts2.size() == 1) {
            return "YES";
        } else if (counts2.size() > 2) {
            return "NO";
        }


        logger.info("## counts2.keySet().stream().min(Integer::compareTo)) : {}, {}", counts2.keySet().stream().min(Integer::compareTo), counts2.get(counts2.keySet().stream().min(Integer::compareTo).get()));

        if (Optional.ofNullable(counts2.get(counts2.keySet().stream().min(Integer::compareTo).get())).orElse(0) > 1) {
            return "NO";
        }

        return "YES";
        // Complete this function
    }

    public static void main(String[] args) {

        //String s = RandomStringUtils.randomAlphabetic(100);
        String s = "hfchdkkbfifgbgebfaahijchgeeeiagkadjfcbekbdaifchkjfejckbiiihegacfbchdihkgbkbddgaefhkdgccjejjaajgijdkd";
        logger.info("## INPUT : {}", s);
        String result = isValid(s);
        System.out.println(result);
    }

}
