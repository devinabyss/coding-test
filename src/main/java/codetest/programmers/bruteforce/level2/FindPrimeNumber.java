package codetest.programmers.bruteforce.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
@Slf4j
public class FindPrimeNumber {

    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> cache = new HashSet<>();
        String[] combineCases = combineCases(numbers);
        for (String str : combineCases) {
            if (isNewPrimeNumber(Integer.parseInt(str), cache))
                answer++;
        }
        return answer;
    }

    private String[] combineCases(String str) {

        log.info("## STR : {}, {}", str, str.length());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(i, i + 1);


            set.add(cur);

            String rest = str.substring(0, i) + str.substring(i + 1, str.length());

            String[] restResult = combineCases(rest);

            for (int j = 0; j < restResult.length; j++) {
                set.add(cur + restResult[j]);
            }
        }

        log.info("## RESULT : {}", set);
        return set.stream().toArray(String[]::new);
    }


    private boolean isNewPrimeNumber(int number, Set<Integer> cache) {
        if (cache.contains(number))
            return false;

        cache.add(number);
        return isPrimeNumber(number);
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 2) return number == 2;

        if (number % 2 == 0) return false;

        // 홀수 중 절반을 넘는 숫자로 나누는 것은 무의미함. 나눗셈으로 떨어지지 않는다.
        for (int i = 3; i <= (number / 2) + 1; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {

        String[] testCases = {
                "17", "011"
        };

        for (String testCase : testCases) {
            int result = solution(testCase);
            log.info("## Result : {}", result);
        }


    }
}
