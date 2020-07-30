package codetest.programmers.stackque.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 */
@Slf4j
public class Tower {


    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i = heights.length - 1; i > 0; i--) {
            int sendValue = heights[i];
            int[] temp = Arrays.copyOfRange(heights, 0, i);
            //log.info("## Temp : {}", Arrays.toString(temp));
            int received = -1;
            for (int j = temp.length - 1; j >= 0; j--) {
                //log.info("## j : {}, j val : {}, sendVal : {}", j, temp[j], sendValue);
                if (temp[j] > sendValue) {
                    received = j;
                    break;
                }
            }
            answer[i] = received < 0 ? 0: received +1;

        }
        answer[0] = 0;
        return answer;
    }


    @Test
    public void test() {

        int[][] testCases = {
                {6, 9, 5, 7, 4},
                {3, 9, 9, 3, 5, 7, 2},
                {1, 5, 3, 6, 7, 6, 5}
        };

        for (int[] tc : testCases) {
            int[] result = solution(tc);
            log.info("## Result : {}", Arrays.toString(result));
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(1);

        log.info("## Stack Length : {}", stack.size());
        stack.peek();
        log.info("## Stack Length : {}", stack.size());
        stack.pop();
        log.info("## Stack Length : {}", stack.size());


    }
}
