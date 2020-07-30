package codetest.programmers.heap.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * 2차 정렬이 안되고 있는 상태. 아 괜히 재귀로 했다.
 */
@Slf4j
public class HardDisk {

    public int sumOfAccessTime(int[][] jobs, int start) {
        if (jobs.length == 0) return 0;
        //if (jobs.length == 1) return jobs[0][0];

        int prev = (jobs[0][0] > start) ? jobs[0][0] - start : 0;
        int totalTime = prev + jobs[0][1] + start;
        int pivot = totalTime - (jobs[0][0]);


        //int pivot = jobs[0][1];

        int[][] prevJobs = Arrays.stream(Arrays.copyOfRange(jobs, 1, jobs.length))
                .filter(a -> a[0] <= pivot)
                .sorted((a, b) -> Integer.compare(a[1], b[1]))
                .toArray(a -> new int[a][1]);
        int[][] afterJobs = Arrays.stream(Arrays.copyOfRange(jobs, 1, jobs.length))
                .filter(a -> a[0] > pivot)
                .sorted((a, b) -> Integer.compare(a[1], b[1]))
                .toArray(a -> new int[a][1]);

        log.info("## start : {}, prev : {}, total : {}, execute : {}", start, prev, totalTime, pivot);
//        log.info("## prev : {}", Arrays.deepToString(prevJobs));
//        log.info("## after : {}", Arrays.deepToString(afterJobs));

        return sumOfAccessTime(prevJobs, totalTime) + sumOfAccessTime(afterJobs, Arrays.stream(prevJobs).mapToInt(a -> a[1]).sum() + totalTime) + pivot;
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> (Integer.compare(a[0], b[0]) == 0) ? Integer.compare(a[1], b[1]) : (Integer.compare(a[0], b[0])));
//        int prev = sumOfAccessTime(jobs, 0);
//        int after = sumOfAccessTime(jobs, prev);
        int sum = sumOfAccessTime(jobs, 0);

        log.info("## sum : {}, length : {}", sum, jobs.length);
        return sum / jobs.length;
    }

    @Test
    public void test() {
//        int[][] input = new int[][]{{0, 3}, {1, 9}, {2, 6}
//                , {35, 5}, {35, 9}, {35, 4},{55,5}};
        //int[][] input = {{0,3},{0,1},{4,7}};
        //int[][] input = {{0, 5}, {1, 2}, {5, 5}};
        //int[][] input = {{0, 3}, {1, 9}, {500, 6}};
        int[][] input = {{0, 10}, {4, 10}, {5, 11}, {15, 2}};
        log.info("## Stream : {}", Arrays.deepToString(input));
        int result = solution(input);
        log.info("## Result : {}", result);
    }


}
