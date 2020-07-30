package codetest.programmers.greedy.level3;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42886
 * https://ydeer.tistory.com/55
 * https://sihyungyou.github.io/programmers-%EC%A0%80%EC%9A%B8/
 */
@Slf4j
public class Balances {


    public int solution(int[] weight) {
        Arrays.sort(weight);

        if (weight[0] > 1) return 1;

        int sum = weight[0];
        /**
         * 완전 수학 규칙! 이건 법칙!
         * 정렬된 구성 요소로 구할 수 있는 숫자 = sum + 1 이 다음 숫자보다 크면 sum + 다음 숫자 만큼은 조합을 낼 수 있다.
         */
        for (int i = 1; i < weight.length; i++) {
            if (sum + 1 < weight[i]) break;
            sum += weight[i];
        }
        return sum + 1;
    }

    @Test
    public void test() {
        int[] input = new int[]{3, 1, 6, 2, 7, 30, 1};
        int result = solution(input);
        log.info("## Result : {}", result);
    }
}
