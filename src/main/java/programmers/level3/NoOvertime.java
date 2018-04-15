package programmers.level3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by HK on 2018-04-11.
 */
public class NoOvertime {
    private final Logger logger = LoggerFactory.getLogger(NoOvertime.class);

    public int noOvertime(int no, int[] works) {

        // 야근 지수를 최소화 하였을 때의 야근 지수는 몇일까요?

        for (int i = 0; no > 0; i++) {

            if (i == 0 && (Arrays.stream(works).max().getAsInt() == works[i])) {
                works[i]--;
                no--;

            } else if (works[i % works.length] == Arrays.stream(works).max().getAsInt()) {
                works[i % works.length]--;
                no--;
            }
        }

        AtomicInteger result = new AtomicInteger(0);
        Arrays.stream(works).forEach(num -> result.addAndGet(num * num));
        return result.get();
    }

    public static void main(String[] args) {
        NoOvertime c = new NoOvertime();
        int[] test = {4, 3, 3};


        System.out.println(c.noOvertime(4, test));
    }
}
