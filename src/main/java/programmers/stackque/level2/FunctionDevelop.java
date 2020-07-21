package programmers.stackque.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
@Slf4j
public class FunctionDevelop {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> distributed = new ArrayList<>();
        int passed = 1;
        boolean[] completed = new boolean[progresses.length];
        while (!allCompleted(completed)) {
            int distribute = 0;
            for (int i = 0; i < progresses.length; i++) {
                if (completed[i])
                    continue;
                completed[i] = 100 <= pros(progresses[i], speeds[i], passed);
                if (completed[i])
                    distribute++;
                else break;
            }

            if (distribute > 0) {
                distributed.add(distribute);
            }

            passed++;
        }
        return distributed.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean allCompleted(boolean[] completed) {
        for (int i = 0; i < completed.length; i++) {
            if (!completed[i])
                return completed[i];
        }
        return true;
    }

    public int pros(int a, int b, int c) {
        return a + (b * c);
    }


    @Test
    public void test() {

        int[][] progresses = {

                {93, 30, 55}
        };

        int[][] speeds = {
                {1, 30, 5}
        };

        for (int i = 0; i < progresses.length; i++) {
            int[] result = solution(progresses[i], speeds[i]);
            log.info("## Result : {}", Arrays.toString(result));
        }

    }


}
