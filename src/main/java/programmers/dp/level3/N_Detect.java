package programmers.dp.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
@Slf4j
public class N_Detect {

    public int sol(int count, int N, int number, Map<Integer, Set<Integer>> cache) {

        int repeatedNumber = Integer.parseInt(String.valueOf(N).repeat(count));
        if (repeatedNumber == number) return count;

        Set<Integer> current = new HashSet<>();
        current.add(repeatedNumber);

        for (int i = 1; i < count; i++) {
            Set<Integer> tempSet = new HashSet<>();
            for (Integer prev : cache.getOrDefault(count - i, new HashSet<>())) {
                for (Integer prev2 : cache.getOrDefault(i, new HashSet<>())) {
                    int temp = prev + prev2;
                    if (temp == number) return count;
                    else tempSet.add(temp);

                    temp = prev - prev2;
                    if (temp == number) return count;
                    else tempSet.add(temp);

                    temp = prev * prev2;
                    if (temp == number) return count;
                    else tempSet.add(temp);

                    if (prev2 == 0) continue;
                    temp = prev / prev2;
                    if (temp == number) return count;
                    else tempSet.add(temp);
                }
            }
            current.addAll(tempSet);
        }

        current.remove(0);
        cache.put(count, current);

        return count > 7 ? -1 : sol(count + 1, N, number, cache);
    }


    public int solution(int N, int number) {
        final Map<Integer, Set<Integer>> cache = new HashMap<>();
        int result = sol(1, N, number, cache);
        log.info("## N : {}, number : {}, Cache : {}", N, number, cache);
        return result;
    }


    @Test
    public void test() {
        int resultA = solution(5, 12);
        int resultB = solution(2, 22);

        log.info("## Result A : {}", resultA);
        log.info("## Result B : {}", resultB);

        Assert.assertEquals(4, resultA);
        Assert.assertEquals(2, resultB);

    }

}
