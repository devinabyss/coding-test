package codetest.programmers.dfsbfs.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class Network {


    private boolean hasNetwork(int target, int[][] computers) {

        if (computers[target][target] == 0)
            return false;

        computers[target][target] = 0;
        //log.info("## target : {}, computers : {}", target, Arrays.deepToString(computers));

        for (int i = 0; i < computers.length; i++) {
            if (computers[target][i] == 1) hasNetwork(i, computers);

        }
        return true;
    }

    public int solution(int n, int[][] computers) {
        int networks = 0;
        for (int i = 0; i < computers.length; i++) {
            if (computers[i][i] > 0 && hasNetwork(i, computers))
                networks++;

        }

        return networks;
    }

    @Test
    public void test() {

        int[] n = {3, 3};
        int[][][] testCases = {
                {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},

                {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
        };

        for (int i = 0; i < n.length; i++) {
            int result = solution(n[i], testCases[i]);
            log.info("## result : {}", result);
        }

    }


//    public int solution(int n, int[][] computers) {
//
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//
//        for (int i = 0; i < computers.length; i++) {
//            Set<Integer> set = new HashSet<>();
//            for (int j = 0; j < computers[i].length; j++) {
//                if (computers[i][j] == 1) set.add(j);
//            }
//            map.put(i, set);
//        }
//
//
//
//        for (Set<Integer> set : map.values()) {
//
//        }
//
//        return 0;
//    }


}
