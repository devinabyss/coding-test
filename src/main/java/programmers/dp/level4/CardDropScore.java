package programmers.dp.level4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42896
 */
@Slf4j
public class CardDropScore {


    public int sol(int[] left, int[] right, int[][] cache, int leftIdx, int rightIdx) {

        if (leftIdx == left.length || rightIdx == right.length) return 0;

        if (cache[leftIdx][rightIdx] != -1) return cache[leftIdx][rightIdx];

        if (left[leftIdx] > right[rightIdx]) {
            int result = right[rightIdx] + sol(left, right, cache, leftIdx, rightIdx + 1);
            cache[leftIdx][rightIdx] = result;
            return result;
        }


        int result = Math.max(sol(left, right, cache, leftIdx-1, rightIdx-1), sol(left, right, cache, leftIdx-1, rightIdx));
        cache[leftIdx][rightIdx] = result;


        return result;
    }

    public int solution(int[] left, int[] right) {
        int[][] cache = new int[left.length][right.length];
        Arrays.stream(cache).forEach(arr -> Arrays.fill(arr, -1));


        return sol(left, right, cache, 0, 0);
    }


    @Test
    public void test() {

        int[] left = new int[]{1, 1, 1, 1, 3};
        int[] right = new int[]{2, 3, 1, 1, 1};
        int result = solution(
                left,
                right
        );

        log.info("## Right Sum : {}", Arrays.stream(right).sum());
        log.info("## Result : {}", result);

        //Assert.assertEquals(7, result);
    }


    public class Failed {
        private Map<Integer, Long> leftNumbers;

        public int solution(int[] left, int[] right) {

            leftNumbers = Arrays.stream(left).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


            int leftIdx = 0;
            int rightIdx = 0;
            int score = 0;
            while (left.length >= leftIdx + 1 && right.length >= rightIdx + 1) {
                int leftNum = left[leftIdx];
                int rightNum = right[rightIdx];
                boolean rightSmaller = leftNum > rightNum;
                if (rightSmaller) {
                    score += rightNum;
                    rightIdx++;
                } else if (hasLeftBiggerOrSameNumber(rightNum)) {
                    adjustLeftNumbers(leftNum);
                    leftIdx++;
                } else {
                    adjustLeftNumbers(leftNum);
                    rightIdx++;
                    leftIdx++;
                }
            }


            return score;
        }

        public void adjustLeftNumbers(int number) {
            Long currentCount = leftNumbers.getOrDefault(number, 0L);
            Long changeCount = currentCount - 1L;
            if (changeCount <= 0L) leftNumbers.remove(number);
            else leftNumbers.put(number, changeCount);
        }


        public boolean hasLeftBiggerOrSameNumber(int num) {
            List<Integer> biggerNumbers = leftNumbers.keySet()
                    .stream().filter(n -> n > num && leftNumbers.getOrDefault(n, 0L) > 0L).collect(Collectors.toList());
            return biggerNumbers.size() > 0;
        }

        @Test
        public void test() {


            //int result = solution(new int[]{3, 2, 5}, new int[]{2, 4, 1});
//        int[] left = new int[]{1, 1, 1, 1, 4, 1, 1, 3, 1, 1, 1};
//        int[] right = new int[]{3, 1, 1, 1, 1, 1, 4, 4, 1, 1, 1};
            int[] left = new int[]{1, 1, 1, 1, 3};
            int[] right = new int[]{2, 3, 1, 1, 1};
            int result = solution(
                    left,
                    right
            );

            log.info("## Right Sum : {}", Arrays.stream(right).sum());
            log.info("## Result : {}", result);

            //Assert.assertEquals(7, result);
        }
    }

}
