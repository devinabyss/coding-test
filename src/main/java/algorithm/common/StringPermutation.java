package algorithm.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class StringPermutation {

    public String[] permutation(String str) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(i, i + 1);
            set.add(cur);

            String rest = str.substring(0, i) + str.substring(i + 1, str.length());

            String[] restResult = permutation(rest);

            for (int j = 0; j < restResult.length; j++) {
                set.add(cur + restResult[j]);
            }
        }

        return set.stream().toArray(String[]::new);
    }

    @Test
    public void test() {

        String[] result = permutation("ABCD");
        log.info("## Result : {}", Arrays.toString(result));

    }
}
