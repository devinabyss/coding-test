package codetest.programmers.stackque.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
@Slf4j
public class TruckThroughBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //int[] passed = new int[truck_weights.length];

        List<Integer> passed = new ArrayList<>();
        Map<Integer, Integer> passing = new LinkedHashMap<>();


        boolean allPassed = isAllPassed(truck_weights, passed);
        int time = 0;
        while (!allPassed) {


            passCurrent(weight, bridge_length, passing, passed, truck_weights);
            time++;
            allPassed = isAllPassed(truck_weights, passed);
            //log.info("# time : {}, allPased : {}", time, allPassed);
//            if (time > 100) break;
        }


        return time;
    }

    private void passCurrent(int bridgeWeight, int bridgeLength, Map<Integer, Integer> passing, List<Integer> passed, int[] trucks) {

        Set<Integer> toRemove = new HashSet<>();
        for (Integer truckKey : passing.keySet()) {
            int passedLength = passing.get(truckKey) + 1;

            if (passedLength > bridgeLength) {
                toRemove.add(truckKey);
                passed.add(truckKey);
            } else {
                passing.put(truckKey, passedLength);
            }
        }

        for (Integer removePos : toRemove) {
            passing.remove(removePos);
        }

        int[] passingg = Arrays.copyOfRange(trucks,
                passing.keySet().stream().mapToInt(Integer::intValue).min().orElseGet(() -> 0),
                passing.keySet().stream().mapToInt(Integer::intValue).max().orElseGet(() -> -1) + 1
        );
        //log.info("## Passing : {}, copeid : {} ", passing, passingg);

        int passingTruckWeight = Arrays.stream(passingg).sum();

        if (passingTruckWeight < bridgeWeight) {
            int currentWorking = passed.size() + passing.size();
            if (trucks.length > currentWorking) {
                int currentPos = currentWorking;
                if (trucks[currentPos] + passingTruckWeight <= bridgeWeight) {
                    //log.info("## current : {}, passing : {}", trucks[currentPos], passingTruckWeight);
                    passing.putIfAbsent(currentPos, 1);
                }
            }

        }


        //log.info("## Passed : {}, Passing: {}", passed, passing);

    }

    private boolean isAllPassed(int[] original, List<Integer> passed) {
        return passed.size() == original.length;
    }


    @Test
    public void test() {

        int[] lengths = {2, 100, 100};

        int[] weights = {10, 100, 100};

        int[][] trucks = {
                {7, 4, 5, 6},
                {10},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}


        };

        for (int i = 0; i < weights.length; i++) {
            int result = solution(lengths[i], weights[i], trucks[i]);
            log.info("## Result : {}", result);
        }

        Map<Integer, Integer> linked = new LinkedHashMap<>();
        linked.put(5, 4);
        linked.put(8, 2);
        linked.put(2, 5);

        log.info("## linked : {}", linked);

        log.info("## linked keyset : {}", linked.keySet());
    }
}
