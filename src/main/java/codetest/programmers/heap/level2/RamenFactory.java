package codetest.programmers.heap.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RamenFactory {

    public int solution(int stock, int[] dates, int[] supplies, int k) {


        int count = 0;
        int answer = 0;

        for (int i = 0; i < dates.length; i++) {
            stock -= (dates[i] - (i == 0 ? 0 : dates[i - 1]));
            k -= (dates[i] - (i == 0 ? 0 : dates[i - 1]));


            int comp = i == dates.length-1 ? k : dates[i+1] - dates[i] ;
            log.info("## stock : {}, k : {}, date[i] : {}, comp : {}", stock, k, dates[i], comp);
            if (stock < comp) {

                stock += supplies[i];
                answer++;
            }

        }


        return answer;
    }


    @Test
    public void test() {

        int[] stocks = {4, 5, 4};
        int[][] dates = {
                {4, 10, 15},
                {3, 5, 10},
                {2, 4, 10, 15}
        };
        int[][] supplies = {
                {11, 5, 20},
                {5, 5, 20},
                {15, 20, 5, 3}
        };
        int[] k = {30, 20, 30};

        for (int i = 0; i < stocks.length; i++) {
            int result = solution(stocks[i], dates[i], supplies[i], k[i]);
            log.info("## Result : {}", result);
        }

    }


}
