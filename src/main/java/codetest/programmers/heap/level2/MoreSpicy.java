package codetest.programmers.heap.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 재귀는 성능테스트 통과 실패
 * 1 depth recursive 라서 dp 먹일 건덕지도 없는 것으로 현재까지는 판단.
 * LinkedList 로도 성능 테스트 실패
 */
@Slf4j
public class MoreSpicy {

    private int[] cache = new int[1000000];


    private int solution(LinkedList<Integer> scoville, int K, int count) {

        //log.info("## input : {}, {}", scoville, scoville.getClass().getCanonicalName());

        if (scoville.size() < 2)
            return scoville.pollFirst() >= K ? 0 : -1;

        int min = scoville.pollFirst();


        if (min >= K)
            return 0;

        int min2 = scoville.pollFirst();

        int maded = min + (min2 * 2);

        //log.info("## removed  :{}, Maded : {}", scoville, maded);

        int idx = scoville.size();

        for (int i = 0; i < scoville.size(); i++) {
            if (scoville.get(i) >= maded) {
                idx = i;
                break;
            }
        }


        //log.info("## Index : {}" , idx);

        scoville.add(idx, maded);

        int continued = solution(scoville, K, count + 1);

        return continued >= 0 ? continued + 1 : -1;
    }


    private int solution(PriorityQueue<Integer> scoville, int K) {

        log.info("## input : {}, {}", scoville, scoville.getClass().getCanonicalName());

        if (scoville.size() < 2)
            return scoville.peek() >= K ? 0 : -1;

        int min = scoville.poll();

        if (min >= K)
            return 0;

        int min2 = scoville.poll();

        int maded = min + (min2 * 2);

        log.info("## removed  :{}, Maded : {}", scoville, maded);


        scoville.add(maded);

        int continued = solution(scoville, K);

        return continued >= 0 ? continued + 1 : -1;
    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> que = Arrays.stream(scoville).sorted().boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int count = 0;
        while (true) {
            int min = que.poll();
            if (que.size() < 1)
                return min >= K ? count : -1;

            if (min >= K)
                break;

            int min2 = que.poll();
            int maded = min + (min2 * 2);
            que.add(maded);
            count++;
        }

        return count;
    }

    @Test
    public void test() {

        int[] numbers = {7, 4, 7};
        int[][] testCases = {
                {1, 2, 3, 9, 10, 12},
                {5, 5, 5, 5},
                {1, 1, 100}
        };

        for (int i = 0; i < numbers.length; i++) {
            int result = solution(testCases[i], numbers[i]);
            log.info("## result : {} ", result);
        }

    }
}
