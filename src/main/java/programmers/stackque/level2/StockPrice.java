package programmers.stackque.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int curVal = prices[i];
            int a = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int compVal = prices[j];
                if (compVal < curVal){
                    a = j;
                    break;
                }
            }
            answer[i] = a == 0? (prices.length-1) - i : a - i;

        }

        return answer;
    }


    @Test
    public void test() {


        int[][] testCases = {
                {1, 2, 3, 2, 3}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution(testCases[i]);
            log.info("## Result : {}", Arrays.toString(result));
        }

    }
}
