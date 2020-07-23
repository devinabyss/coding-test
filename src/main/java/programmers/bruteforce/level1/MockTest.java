package programmers.bruteforce.level1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class MockTest {

    private final int[] personCAnswers = {3, 1, 2, 4, 5};
    private final int[] personBAnswers = {1, 3, 4, 5};

    public int[] solution(int[] answers) {

        int[] check = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int personA = personA(i);
            int personB = personB(i);
            int personC = personC(i);

            if (personA == answers[i])
                check[0]++;

            if (personB == answers[i])
                check[1]++;

            if (personC == answers[i])
                check[2]++;
            //log.info("## A : {}, B : {}, C : {}, Position : {}, ANSWER : {}", personA, personB, personC, i, answers[i]);
        }

        int max = Arrays.stream(check).max().getAsInt();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < check.length; i++) {
            if (max == check[i])
                result.add(i + 1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int personA(int position) {
        int rest = (position + 1) % 5;
        return rest == 0 ? 5 : rest;
    }

    public int personB(int position) {
        boolean isEven = position % 2 == 0;
        return isEven ? 2 : personBAnswers[(position % 8) / 2];
    }

    public int personC(int position) {
        return personCAnswers[position % 10 / 2];
    }


    @Test
    public void test() {

        int[][] testCases = {
                {1, 3, 2, 4, 2, 1, 2, 3, 4, 5, 2, 3},
                {1, 2, 3, 4, 5},
                {1, 3, 2, 4, 2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution(testCases[i]);
            log.info("## Result : {}", Arrays.toString(result));
        }

    }
}
