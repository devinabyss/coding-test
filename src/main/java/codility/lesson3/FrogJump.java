package codility.lesson3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * https://app.codility.com/demo/results/trainingR8QKCD-WU2/
 * Result : 100%
 * Created by HK on 2018-04-21.
 */
public class FrogJump {

    private static final Logger logger = LoggerFactory.getLogger(FrogJump.class);

    public int solution(int X, int Y, int D) {

        int distance = Y - X;
        int div = distance / D;
        int rest = distance % D;

        //logger.info("## Distance : {}, Divided {}, Rest : {}", distance, div, rest );

        return rest == 0 ? div : div + 1;
    }

    public static void main(String[] args) {

        int[] test1 = {10, 85, 30};

        FrogJump frogJump = new FrogJump();
        LocalDateTime now = LocalDateTime.now();
        int result = frogJump.solution(test1[0], test1[1], test1[2]);
        logger.info("## Result : {}, Time : {}", result, now.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }
}
