package codetest.programmers.oold.level2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class HelpBoat {


    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;
        int count = 0;
        while (min <= max) {
            if (people[min] + people[max] > limit) {
                max--;
            } else {
                min++;
                max--;
            }
            count++;

        }

        return count;
    }

    @Test
    public void test() {

        log.info("## Result : {}", solution(new int[]{70, 50, 80, 50}, 100));
    }
}
