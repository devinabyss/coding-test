package programmers.hash.level1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HK on 2018-04-22.
 */
public class Fibonacci {

    private static final Logger logger = LoggerFactory.getLogger(Fibonacci.class);


    public long fibonacci(int num) {
        long answer = 0;

        if (num == 0 || num == 1) {
            return num;
        }

        long preprev = 0;
        long prev = 1;

        for (int i = 2; i <= num; i++) {
            answer = preprev + prev;
            preprev = prev;
            prev = answer;
            //logger.info ("## i : {}, current : {}", i, answer);
        }
        return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Fibonacci c = new Fibonacci();
        int testCase = 3;
        System.out.println(c.fibonacci(testCase));
    }

}
